package com.practica.tallerMecanico.services.reserva;

import com.practica.tallerMecanico.entities.Reserva;

public interface IReservasServicio{
	
	public Reserva crearReserva(Reserva reserva);
	
	public void modificarReserva(Reserva reserva);	
}
