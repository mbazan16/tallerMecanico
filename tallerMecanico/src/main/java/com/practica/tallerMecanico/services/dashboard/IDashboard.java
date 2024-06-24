package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
import java.util.List;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;

public interface IDashboard {
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)
	public List<Trabajo> getTrabajosHoy(LocalDate fechaHoy) throws ServiceException;
	public List<Trabajo> getTrabajosPendientes()throws ServiceException;
	public List<Trabajo> buscador(String matricula)throws ServiceException;


}
