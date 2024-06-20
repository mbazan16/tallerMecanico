package com.practica.tallerMecanico.services.reserva;

import java.util.List;

import com.practica.tallerMecanico.entities.Reserva;

public interface IReservasServicio{
	
	public Reserva crearReserva(Reserva reserva);
	
	public void modificarReserva(Reserva reserva);
	
	public void anularReserva(Reserva reserva);
	
	public List<Reserva> listarReservas(Reserva reserva);	
}
