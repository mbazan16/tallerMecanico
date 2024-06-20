package com.practica.tallerMecanico.services.reserva;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.ReservaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservasServicio implements IReservasServicio{
	
	@Autowired
	ReservaRepository repository;
	
	public Reserva crearReserva(Reserva reserva) {
		log.info("[crearReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		try {
			//inicializar el estado de la reserva que recibo
			reserva = repository.save(reserva);
		} catch(Exception e) {
			log.error("Error al crear reserva", e);
		}
		return reserva;
	}
	
	public void modificarReserva(Reserva reserva) {
		log.info("[modificarReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		//comprobar que cambios se estan modificando y almacenarlos?
	}
	
	public void anularReserva(Reserva reserva) {
		log.info("[anularReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		//modificar estado reserva a anulada y almacenarla?
	}
	
	public List<Reserva> listarReservas(Reserva reserva) {
		log.info("[listarReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		
		List<Reserva> reservas = repository.findAll();
		return reservas;
	}




	
}
