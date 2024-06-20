package com.practica.tallerMecanico.services.entrega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

@ExtendWith(MockitoExtension.class)
public class EntregaServicioTest {

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
    void testGetTrabajo() {
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
}
