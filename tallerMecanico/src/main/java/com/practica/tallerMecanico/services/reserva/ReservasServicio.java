package com.practica.tallerMecanico.services.reserva;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Reserva;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservasServicio implements IReservasServicio{
	
	//@Autowired
	//Repositorio repository;
	
	public Reserva crearReserva(Reserva reserva) {
//		log.info("[crearReserva]");
//		log.debug("[Reserva: "+reserva.toString()+"]");
		
		//reserva = repository.save(reserva);
		return reserva;
	}

	public void modificarReserva(Reserva reserva) {
//		log.info("[modificarReserva]");
//		log.debug("[Reserva: "+reserva.toString()+"]");
		
		//modificar reserva
		
	}

	
}
