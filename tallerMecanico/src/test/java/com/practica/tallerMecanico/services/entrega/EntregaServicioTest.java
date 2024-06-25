package com.practica.tallerMecanico.services.entrega;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.TrabajoNotFoundException;

@ExtendWith(MockitoExtension.class)
public class EntregaServicioTest {

    @Mock
    private TrabajoRepository trabajoRepository;

    @Mock
    private EntregaRepository entregaRepository;

    @InjectMocks
    private EntregaServicio entregaServicio;

    @Test
    public void testGetTrabajo_TrabajoEncontrado() throws ServiceException {
        // Arrange
        int idTrabajo = 1;
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(idTrabajo);

        when(trabajoRepository.findById(idTrabajo)).thenReturn(Optional.of(trabajoMock));

        // Act
        Trabajo trabajoObtenido = entregaServicio.getTrabajo(idTrabajo);

        // Assert
        assertThat(trabajoObtenido).isEqualTo(trabajoMock);
        verify(trabajoRepository).findById(idTrabajo);
    }

    @Test
    public void testGetTrabajo_TrabajoNoEncontrado() throws ServiceException {
        // Arrange
        int idTrabajo = 1;

        when(trabajoRepository.findById(idTrabajo)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(TrabajoNotFoundException.class, () -> entregaServicio.getTrabajo(idTrabajo));
        verify(trabajoRepository).findById(idTrabajo);
    }

    @Test
    public void testProcesarFecha_FormatoValido() throws ServiceException {
        // Arrange
        int idTrabajo = 1;
        String fecha = "25-06-2023";
        String hora = "14:30";

        // Creamos un trabajo simulado para devolverlo cuando se llame a findById
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(idTrabajo);
        trabajoMock.setCoche(new Coche()); // Simulamos datos necesarios
        trabajoMock.setCliente(new Cliente()); // Simulamos datos necesarios

        when(trabajoRepository.findById(idTrabajo)).thenReturn(java.util.Optional.of(trabajoMock));
        // Mock para el método save del repositorio de trabajo
        when(trabajoRepository.save(any(Trabajo.class))).thenReturn(trabajoMock);
        // Mock para el método save del repositorio de entrega
        when(entregaRepository.save(any(Entrega.class))).thenReturn(new Entrega()); // Podemos devolver un objeto Entrega simulado

        // Act
        entregaServicio.procesarFecha(fecha, hora, idTrabajo);

        // Assert
        // Verificar que se llamó a findById del trabajoRepository
        verify(trabajoRepository).findById(idTrabajo);
        // Verificar que se llamó a save del trabajoRepository con el trabajo actualizado
        verify(trabajoRepository).save(trabajoMock);
        // Verificar que se llamó a save del entregaRepository al menos una vez
        verify(entregaRepository).save(any(Entrega.class));
    }

    @Test
    public void testProcesarFecha_FormatoInvalido() {
        // Arrange
        int idTrabajo = 1;
        String fecha = "Le das y no va"; // Formato inválido
        String hora = "14:30";

        // Act & Assert
        assertThatThrownBy(() -> entregaServicio.procesarFecha(fecha, hora, idTrabajo))
                .isInstanceOf(ServiceException.class)
                .hasMessageContaining("Formato de fecha inválido: " + fecha);
    }

}
