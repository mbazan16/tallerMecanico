package com.practica.tallerMecanico.services.reserva;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.common.ReservaEstado;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.common.MessageError;
import com.practica.tallerMecanico.services.common.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservasServicio implements IReservasServicio{
	
	@Autowired
	ReservaRepository repository;
	
	public Reserva crearReserva(Reserva reserva) {
		log.info("[crearReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		//LocalDateTime fechaActual = LocalDateTime.now();
		try {
			reserva.setReservaEstado(ReservaEstado.PENDIENTE);
			//reserva.setFechaReserva((Date)fechaActual.now());
			reserva = repository.save(reserva);
		} catch(Exception e) {
			log.error("Error al crear reserva", e);
		}
		return reserva;
	}
	
	public Reserva modificarReserva(Reserva reservaMod) {
		log.info("[modificarReserva]");
		log.debug("[modificarReserva:"+reservaMod.toString()+"]");
		
		Reserva reservaExistente = null;
		Optional<Reserva> reservaOpcional = repository.findById(reservaMod.getId());
		if(!reservaOpcional.isPresent()) {
			//mensaje error no se encontro la reserva
		} 
		reservaExistente = reservaOpcional.get();
		reservaExistente.setFechaEntrega(reservaMod.getFechaEntrega());
		reservaExistente.setFechaProgramacion(reservaMod.getFechaEntrega());
//		reservaExistente.setTipoTrabajo(reservaMod.getTipoTrabajo());
		reservaExistente.setPrioridad(reservaMod.getPrioridad());
		return repository.save(reservaExistente);
	}
	
	public Reserva anularReserva(Reserva reservaAnular) {
		log.info("[anularReserva]");
		log.debug("[reservaAnulada: "+reservaAnular.toString()+"]");
		
		Reserva reservaExistente = null;
		Optional<Reserva> reservaOpcional = repository.findById(reservaAnular.getId());
		if(!reservaOpcional.isPresent()) {
			//mensaje error no se encontro la reserva
			}
		reservaExistente = reservaOpcional.get();
		if(!ReservaEstado.PENDIENTE.equals(reservaExistente.getReservaEstado())) {
			//mensaje error la reserva ya esta anulada o ejecutada
		}
		reservaExistente.setReservaEstado(ReservaEstado.ANULADA);
		return reservaExistente;
	}
	
	public List<Reserva> listarReservas() {
		log.info("[listarReserva]");
		
		List<Reserva> reservas = null;
		try {
			reservas = repository.findAll();
			if(reservas.isEmpty()) throw new ReservaException(/*No es el correspondiente*/ErrorCode.EC_EXCEPCION_GENERAL);
		} catch(ReservaException re) {
			log.error(/*Mensaje sin elementos*/"Error sin elementos", re);
			//throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}

	public List<Reserva> buscar(Date fecha, ReservaEstado estado, String matricula, String telefono) {
		log.info("[buscar]");
		log.debug("[buscar: "+matricula+telefono+"]");
		List<Reserva> reservas = null;
		try {
			if(matricula==null || matricula.equals("")) {
				//reservas = repository.findByTelefono(); findAllByClienteTelefono
			}else {
				//reservas = repository.findByMatricula(); findAllByCocheMatricula
			}//hay que cambiar el flujo para buscar tambien por fecha y estado 
			
			
			
			if(reservas.isEmpty()) throw new ReservaException(/*Error de sin elementos*/ErrorCode.EC_EXCEPCION_GENERAL);
		} catch(ReservaException re) {
			log.error(/*mensaje sin elementos*/"Error sin elementos", re);
			//throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}
	
}
