package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.practica.tallerMecanico.entities.Trabajos;

@Service
public class DashboardServicio implements IDashboard{
	//Trazas
		public static final Logger log = LoggerFactory.getLogger(Trabajo.class);
	@Autowired
	Trabajo trabajo = new Trabajo();
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)

	public List<Trabajos> getTrabajosHoy() {
		LocalDate fechaHoy = LocalDate.now();
        return TrabajoRepository.getTrabajosHoy(fechaHoy);

		
	}

}
