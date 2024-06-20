package com.practica.tallerMecanico.services.entrega;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;

public interface IEntregaServicio {
	
	public Trabajo getTrabajo(Integer id) throws ServiceException;
	public void procesarFecha(String fecha) throws ServiceException;

}