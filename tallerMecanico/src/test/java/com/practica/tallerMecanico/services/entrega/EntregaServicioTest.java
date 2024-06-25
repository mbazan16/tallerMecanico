package com.practica.tallerMecanico.services.entrega;

<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
>>>>>>> refs/heads/reservas
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

<<<<<<< HEAD

=======
>>>>>>> refs/heads/reservas
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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

@ExtendWith(MockitoExtension.class)
public class EntregaServicioTest {

    @Mock
<<<<<<< HEAD
    private TrabajoRepository trabajoRepository;

    @Mock
    private EntregaRepository entregaRepository;
=======
    private TrabajoRepository repository;
>>>>>>> refs/heads/reservas

    @InjectMocks
    private EntregaServicio service;

<<<<<<< HEAD
    @Test
    public void testGetTrabajo_TrabajoEncontrado() throws ServiceException {
        // Arrange
        int idTrabajo = 1;
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(idTrabajo);

        when(trabajoRepository.findById(idTrabajo)).thenReturn(Optional.of(trabajoMock));
=======
    private Trabajo trabajo;
>>>>>>> refs/heads/reservas

<<<<<<< HEAD
        // Act
        Trabajo trabajoObtenido = entregaServicio.getTrabajo(idTrabajo);

        // Assert
        assertThat(trabajoObtenido).isEqualTo(trabajoMock);
        verify(trabajoRepository).findById(idTrabajo);
=======
    @BeforeEach
    void setUp() {
        trabajo = new Trabajo();
        trabajo.setId(1);
        trabajo.setDescripcion("Trabajo de prueba");
>>>>>>> refs/heads/reservas
    }

    @Test
<<<<<<< HEAD
    public void testGetTrabajo_TrabajoNoEncontrado() throws ServiceException {
        // Arrange
        int idTrabajo = 1;
=======
    void testGetTrabajo() {
        // Configurar el comportamiento del mock
        when(repository.findById(1)).thenReturn(Optional.of(trabajo));
>>>>>>> refs/heads/reservas

<<<<<<< HEAD
        when(trabajoRepository.findById(idTrabajo)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(TrabajoNotFoundException.class, () -> entregaServicio.getTrabajo(idTrabajo));
        verify(trabajoRepository).findById(idTrabajo);
=======
        // Llamar al método a probar
        Trabajo result = service.getTrabajo(1);

        // Verificar los resultados
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Trabajo de prueba", result.getDescripcion());

        // Verificar que el método del repositorio se haya llamado con el ID correcto
        verify(repository, times(1)).findById(1);
>>>>>>> refs/heads/reservas
    }
<<<<<<< HEAD

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

=======
>>>>>>> refs/heads/reservas
}
