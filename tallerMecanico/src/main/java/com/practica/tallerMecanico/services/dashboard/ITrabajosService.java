package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDateTime;
import java.util.List;

import com.practica.tallerMecanico.entities.Trabajos;

public interface ITrabajosService {
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)
	public List<Trabajos> getTrabajosHoy(LocalDateTime fechaHoy);
}
