package com.practica.tallerMecanico.services.entrega;

import com.practica.tallerMecanico.entities.Trabajo;

public interface IEntregaServicio {
	
<<<<<<< HEAD
	public Trabajo getTrabajo(Integer id) throws ServiceException;
	public void procesarFecha(String fecha, String hora ,int id) throws ServiceException;
	public void insertarEntrega(LocalDateTime fechaProcesada, int id) throws ServiceException;
=======
	public Trabajo getTrabajo(Integer id);

>>>>>>> refs/heads/reservas
}