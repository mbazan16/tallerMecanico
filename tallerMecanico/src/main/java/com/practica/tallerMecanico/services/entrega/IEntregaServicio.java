package com.practica.tallerMecanico.services.entrega;

import java.time.LocalDateTime;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;

public interface IEntregaServicio {
	
	public Trabajo getTrabajo(Integer id) throws ServiceException;
	public void procesarFecha(String fecha, int id) throws ServiceException;
	public void insertarFecha(LocalDateTime fechaProcesada, int id) throws ServiceException;
}