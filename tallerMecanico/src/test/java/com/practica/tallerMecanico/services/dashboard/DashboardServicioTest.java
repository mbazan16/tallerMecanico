package com.practica.tallerMecanico.services.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ServiceException;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Rollback
public class DashboardServicioTest {

    @Mock
    private TrabajoRepository trabajoRepository;

    @InjectMocks
    private DashboardServicio dashboardServicio;

    private Trabajo trabajo;
    private Coche coche;

    @BeforeEach
    public void setUp() {
        coche = new Coche();
        coche.setId(1);
        coche.setMatricula("ABC123");

        trabajo = new Trabajo();
        trabajo.setId(1);
        trabajo.setCoche(coche);
        trabajo.setEstado(EstadoTrabajo.PENDIENTE);
        trabajo.setFechaProgramacion(LocalDateTime.now());
    }

    @Test
    public void testGetTrabajosHoy() throws ServiceException {
        when(trabajoRepository.findAllByFProgramacion(any(LocalDate.class)))
            .thenReturn(Collections.singletonList(trabajo));

        List<Trabajo> trabajosHoy = dashboardServicio.getTrabajosHoy(LocalDate.now());

        assertEquals(1, trabajosHoy.size());
        verify(trabajoRepository).findAllByFProgramacion(any(LocalDate.class));
    }

    @Test
    public void testGetTrabajosPendientes() throws ServiceException {
        when(trabajoRepository.findAllByEstado(any(EstadoTrabajo.class)))
            .thenReturn(Collections.singletonList(trabajo));

        List<Trabajo> trabajosPendientes = dashboardServicio.getTrabajosPendientes();

        assert(!trabajosPendientes.isEmpty());
        verify(trabajoRepository).findAllByEstado(any(EstadoTrabajo.class));
    }

    @Test
    public void testBuscador() throws ServiceException {
        when(trabajoRepository.findAllByMatricula(anyString()))
            .thenReturn(Collections.singletonList(trabajo));

        List<Trabajo> trabajosXmatricula = dashboardServicio.buscador("ABC123");

        assert(!trabajosXmatricula.isEmpty());
        verify(trabajoRepository).findAllByMatricula(anyString());
    }

    @Test
    public void testIniciarTrabajo() throws ServiceException {
        when(trabajoRepository.findById(any(Integer.class)))
            .thenReturn(Optional.of(trabajo));

        dashboardServicio.iniciarTrabajo(1);

        verify(trabajoRepository).findById(any(Integer.class));
        verify(trabajoRepository).save(any(Trabajo.class));
    }

    @Test
    public void testGetTrabajosEjecucion() throws ServiceException {
        when(trabajoRepository.findAllByEstado(any(EstadoTrabajo.class)))
            .thenReturn(Collections.singletonList(trabajo));

        List<Trabajo> trabajosEjecucion = dashboardServicio.getTrabajosEjecucion();

        assert(!trabajosEjecucion.isEmpty());
        verify(trabajoRepository).findAllByEstado(any(EstadoTrabajo.class));
    }

    @Test
    public void testTerminarTrabajo() throws ServiceException {
        when(trabajoRepository.findById(any(Integer.class)))
            .thenReturn(Optional.of(trabajo));

        dashboardServicio.terminarTrabajo(1);

        verify(trabajoRepository).findById(any(Integer.class));
        verify(trabajoRepository).save(any(Trabajo.class));
    }
}
