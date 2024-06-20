package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDateTime;
import java.util.List;

import com.practica.tallerMecanico.entities.Trabajo;

public interface IDashboard {
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)
	public List<Trabajo> getTrabajosHoy();
	public List<Trabajo> buscador();

}
