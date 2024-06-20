package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

@Service
public class DashboardServicio implements IDashboard{
	//Trazas
		public static final Logger log = LoggerFactory.getLogger(Trabajo.class);
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	LocalDate fechaHoy = LocalDate.now();
	
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)

	public List<Trabajo> getTrabajosHoy() {
		log.info("[Lista trabajos para hoy:]");
		List<Trabajo> trabajos = trabajoRepository.findAllByFechaInicio(fechaHoy);
		log.info("Obteniendo trabajos de hoy (" + fechaHoy + "): " + trabajos.size() + " trabajos encontrados.");
		return trabajos;

	}
	//Trabajo terminados antes de la fecha actual
	public List<Trabajo> getTrabajosTerminadosAntesDe() {
		log.info("[listaTrabajos]");

        return trabajoRepository.findAllByFechaEntregaBefore(fechaHoy);
    }
	//Trabajos pendientes de empezar
	public List<Trabajo> getTrabajosPendientes() {
		log.info("[listaTrabajos]");
        return trabajoRepository.findAllByFechaInicioAfter(fechaHoy);
    }
}
