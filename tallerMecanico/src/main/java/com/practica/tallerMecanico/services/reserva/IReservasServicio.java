package com.practica.tallerMecanico.services.reserva;

import java.util.Date;
import java.util.List;

import com.practica.tallerMecanico.common.ReservaEstado;
import com.practica.tallerMecanico.entities.Reserva;

import com.practica.tallerMecanico.services.reserva.exception.ReservaException;


public interface IReservasServicio{
	
	public Reserva crearReserva(Reserva reserva);
	
	public Reserva modificarReserva(Reserva reserva);
	
	public Reserva anularReserva(Reserva reserva);
	
	public List<Reserva> listarReservas();
	
	public List<Reserva> buscar(Date fecha, ReservaEstado estado, String matricula, String telefono);
	
}
