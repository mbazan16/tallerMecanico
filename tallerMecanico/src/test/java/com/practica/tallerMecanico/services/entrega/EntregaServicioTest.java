package com.practica.tallerMecanico.services.entrega;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.TrabajoNotFoundException;

@ExtendWith(MockitoExtension.class)
public class EntregaServicioTest {

    private static final Logger log = LoggerFactory.getLogger(EntregaServicioTest.class);

    @Mock
    private TrabajoRepository repository;

    @InjectMocks
    private EntregaServicio service;

    private Trabajo trabajo;

    @BeforeEach
    void setUp() {
        trabajo = new Trabajo();
        trabajo.setId(1);
        trabajo.setDescripcion("Trabajo de prueba");
    }

    @Test
    void testGetTrabajo() throws ServiceException {
        // Configurar el comportamiento del mock
        when(repository.findById(1)).thenReturn(Optional.of(trabajo));

        // Llamar al método a probar
        Trabajo result = service.getTrabajo(1);

        // Verificar los resultados
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Trabajo de prueba", result.getDescripcion());

        // Verificar que el método del repositorio se haya llamado con el ID correcto
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testGetTrabajoNotFound() {
        // Configurar el comportamiento del mock para devolver un Optional vacío
        when(repository.findById(1)).thenReturn(Optional.empty());

        // Verificar que se lanza la excepción correcta
        TrabajoNotFoundException exception = assertThrows(TrabajoNotFoundException.class, () -> {
            service.getTrabajo(1);
        });

        assertEquals("Trabajo no encontrado con ID: 1", exception.getMessage());

        // Verificar que el método del repositorio se haya llamado con el ID correcto
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testProcesarFechaValida() throws ServiceException {
        String fecha = "15/06/23 10:30";

        // Llamar al método a probar
        assertDoesNotThrow(() -> service.procesarFecha(fecha));
    }

    @Test
    void testProcesarFechaInvalida() {
        String fechaInvalida = "2023-06-15 10:30";

        // Verificar que se lanza la excepción correcta
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            service.procesarFecha(fechaInvalida);
        });

        assertEquals("Formato de fecha inválido: " + fechaInvalida, exception.getMessage());
    }
}
