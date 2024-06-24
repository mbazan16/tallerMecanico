package com.practica.tallerMecanico.services.reserva;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.common.MessageError;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

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
	
	public List<Reserva> listarReservas(Reserva reserva) throws ReservaException {
		log.info("[listarReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		List<Reserva> reservas = null;
		try {
			reservas = repository.findAll();
			if(reservas.isEmpty()) throw new ReservaException(/*No es el correspondiente*/ErrorCode.EC_EXCEPCION_GENERAL);
		} catch(ReservaException re) {
			log.error(/*Mensaje sin elementos*/"Error sin elementos", re);
			throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}

	public List<Reserva> buscar(String matricula, String telefono) throws ReservaException {
		log.info("[buscar]");
		log.debug("[buscar: "+matricula+telefono+"]");
		List<Reserva> reservas = null;
		try {
			if(matricula==null || matricula.equals("")) {
				//reservas = repository.findByMatricula();
			}else {
				//reservas = repository.findByTelefono();
			}
			if(reservas.isEmpty()) throw new ReservaException(/*Error de sin elementos*/ErrorCode.EC_EXCEPCION_GENERAL);
		} catch(ReservaException re) {
			log.error(/*mensaje sin elementos*/"Error sin elementos", re);
			throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}
	
}
