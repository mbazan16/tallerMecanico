package com.practica.tallerMecanico.services.dashboard;

import java.util.List;

import com.practica.tallerMecanico.dto.TrabajoLPH;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;

public interface IDashboard {
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)
	public List<TrabajoLPH> getTrabajosHoy(Long idMecanico);
	public List<Trabajo> getTrabajosPendientes();
	List<Trabajo> buscador(String matricula)throws ServiceException;


}
