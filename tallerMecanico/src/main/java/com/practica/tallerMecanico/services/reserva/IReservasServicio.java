package com.practica.tallerMecanico.services.reserva;

import java.util.List;

import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.services.common.ReservaException;

public interface IReservasServicio{
	
	public Reserva crearReserva(Reserva reserva);
	
	public void modificarReserva(Reserva reserva);
	
	public void anularReserva(Reserva reserva);
	
	public List<Reserva> listarReservas(Reserva reserva) throws ReservaException;
	
	public List<Reserva> buscar(String matricula, String telefono) throws ReservaException;
	
}
