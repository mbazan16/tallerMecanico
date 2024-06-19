package com.practica.tallerMecanico.services.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServicioReservas implements IServicioReservas{
	
	@Autowired
	Repositorio repository;
	
	public Reserva crearReserva(Reserva reserva) {
		log.info("[crearReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		
		reserva = repository.save(reserva);
		return reserva;
	}

	@Override
	public void modificarReserva(Reserva reserva) {
		log.info("[modificarReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		
		//modificar reserva
		
	}
	
}
