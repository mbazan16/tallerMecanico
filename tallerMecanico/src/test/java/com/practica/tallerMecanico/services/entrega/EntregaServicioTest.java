package com.practica.tallerMecanico.services.entrega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.TrabajoNotFoundException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EntregaServicioTest {

    @Mock
    private TrabajoRepository trabajoRepositoryMock;

    @InjectMocks
    private EntregaServicio entregaServicio;

    @Test
    public void getTrabajo_existente_retornaTrabajo() throws ServiceException {
        // Arrange
        int id = 1;
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(id);
        when(trabajoRepositoryMock.findById(id)).thenReturn(java.util.Optional.of(trabajoMock));

        // Act
        Trabajo trabajo = entregaServicio.getTrabajo(id);

        // Assert
        assertNotNull(trabajo);
        assertEquals(id, trabajo.getId());
    }

    @Test
    public void getTrabajo_noExistente_lanzaTrabajoNotFoundException() {
        // Arrange
        int id = 1;
        when(trabajoRepositoryMock.findById(id)).thenReturn(java.util.Optional.empty());

        // Act + Assert
        assertThrows(TrabajoNotFoundException.class, () -> entregaServicio.getTrabajo(id));
    }

    @Test
    public void insertarFecha_actualizaFechaEntrega() throws ServiceException {
        // Arrange
        int id = 1;
        LocalDateTime fechaProcesada = LocalDateTime.now();
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(id);
        when(trabajoRepositoryMock.findById(id)).thenReturn(java.util.Optional.of(trabajoMock));

        // Act
        entregaServicio.insertarFecha(fechaProcesada, id);

        // Assert
        ArgumentCaptor<Trabajo> trabajoCaptor = ArgumentCaptor.forClass(Trabajo.class);
        verify(trabajoRepositoryMock).save(trabajoCaptor.capture());
        Trabajo trabajoGuardado = trabajoCaptor.getValue();
        assertEquals(fechaProcesada, trabajoGuardado.getFechaEntrega());
    }

    @Test
    public void procesarFecha_fechaValida_llamaInsertarFecha() throws ServiceException {
        // Arrange
        String fecha = "31/12/23 23:59";
        int id = 1;
        LocalDateTime fechaProcesada = LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yy HH:mm"));

        // Mock repository behavior
        Trabajo trabajoMock = new Trabajo();
        trabajoMock.setId(id);
        when(trabajoRepositoryMock.findById(id)).thenReturn(java.util.Optional.of(trabajoMock));

        // Act
        entregaServicio.procesarFecha(fecha, id);

        // Assert
        ArgumentCaptor<LocalDateTime> fechaCaptor = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(entregaServicio).insertarFecha(fechaCaptor.capture(), idCaptor.capture());

        assertEquals(fechaProcesada, fechaCaptor.getValue());
        assertEquals(id, idCaptor.getValue());
    }

    @Test
    public void procesarFecha_fechaInvalida_lanzaServiceException() {
        // Arrange
        String fechaInvalida = "31/12/2023 23:59";
        int id = 1;

        // Act + Assert
        ServiceException exception = assertThrows(ServiceException.class,
                () -> entregaServicio.procesarFecha(fechaInvalida, id));
        assertTrue(exception.getMessage().contains("Formato de fecha inválido"));
    }
}