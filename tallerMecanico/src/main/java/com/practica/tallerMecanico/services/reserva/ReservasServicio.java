package com.practica.tallerMecanico.services.reserva;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.Message;
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
		Date date = new Date();
		try {
			reserva.setReservaEstado(ReservaEstado.PENDIENTE);
			reserva.setFechaReserva(date);
			reserva = repository.save(reserva);
			if(reserva==null || !ReservaEstado.PENDIENTE.equals(reserva.getReservaEstado())) 
				throw new ReservaException(ErrorCode.EC_EXCEPCION_CREAR_RESERVA);
		} catch(ReservaException re) {
			log.error(MessageError.EC_EXCEPCION_CREAR_RESERVA, re);
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reserva;
	}
	
	public Reserva modificarReserva(Reserva reservaMod) {
		log.info("[modificarReserva]");
		log.debug("[modificarReserva:"+reservaMod.toString()+"]");
		
		Reserva reservaExistente = null;
		
		try {
			Optional<Reserva> reservaOpcional = repository.findById(reservaMod.getId());
			if(!reservaOpcional.isPresent()) {
				throw new ReservaException(ErrorCode.EC_EXCEPCION_RESERVA_NO_EXISTE);
			} 
			reservaExistente = reservaOpcional.get();
			reservaExistente.setFechaEntrega(reservaMod.getFechaEntrega());
			reservaExistente.setFechaProgramacion(reservaMod.getFechaEntrega());
			reservaExistente.setTipoTrabajo(reservaMod.getTipoTrabajo());
			reservaExistente.setPrioridad(reservaMod.getPrioridad());
			reservaExistente = repository.save(reservaExistente);
		} catch (ReservaException re) {
			log.error(MessageError.EC_EXCEPCION_RESERVA_NO_EXISTE, re);
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		
		return reservaExistente;
	}
	
	public Reserva anularReserva(Reserva reservaAnular) {
		log.info("[anularReserva]");
		log.debug("[reservaAnulada: "+reservaAnular.toString()+"]");
		
		Reserva reservaExistente = null;
		
		try {
			Optional<Reserva> reservaOpcional = repository.findById(reservaAnular.getId());
			if(!reservaOpcional.isPresent()) {
				throw new ReservaException(ErrorCode.EC_EXCEPCION_RESERVA_NO_EXISTE);
			}
			reservaExistente = reservaOpcional.get();
			if(!ReservaEstado.PENDIENTE.equals(reservaExistente.getReservaEstado())) {
				throw new ReservaException(ErrorCode.EC_EXCEPCION_ANULAR_RESERVA);
			}
			reservaExistente.setReservaEstado(ReservaEstado.ANULADA);
			reservaExistente = repository.save(reservaExistente);
		} catch (ReservaException re) {
			if(ErrorCode.EC_EXCEPCION_ANULAR_RESERVA.equals(re.getCode()))
				log.error(MessageError.EC_EXCEPCION_ANULAR_RESERVA, re);
			if(ErrorCode.EC_EXCEPCION_RESERVA_NO_EXISTE.equals(re.getCode()))
					log.error(MessageError.EC_EXCEPCION_RESERVA_NO_EXISTE,  re);
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservaExistente;
	}
	
	public List<Reserva> listarReservas() {
		log.info("[listarReserva]");
		
		List<Reserva> reservas = null;
		try {
			reservas = repository.findAll();
			if(reservas.isEmpty()) throw new ReservaException(ErrorCode.EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS);
		} catch(ReservaException re) {
			log.error(MessageError.EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS, re);
			//throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}

	public List<Reserva> buscar(Date fecha, ReservaEstado estado, String matricula, String telefono) {
		log.info("[buscar]");
		log.debug("[buscar: "+fecha+estado+matricula+telefono+"]");
		List<Reserva> reservas = null;
		try {
			if(fecha!=null){
				reservas = repository.findByFechaReserva(fecha);
			}else if(estado!=null){
				reservas = repository.findAllByReservaEstado(estado);
			}else if(matricula != null) {
				reservas = repository.findAllByCoche(matricula);
			}else if(telefono!=null) {
				reservas = repository.findAllByCliente(telefono);
			}else {
				throw new ReservaException(ErrorCode.EC_EXCEPCION_CAMPOS_BUSQUEDA_VACIOS);
			}
			if(reservas.isEmpty()) throw new ReservaException(ErrorCode.EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS);
		} catch(ReservaException re) {
			if(ErrorCode.EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS.equals(re.getCode()))
				log.error(MessageError.EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS, re);
			if(ErrorCode.EC_EXCEPCION_CAMPOS_BUSQUEDA_VACIOS.equals(re.getCode()))
				log.error(MessageError.EC_EXCEPCION_CAMPOS_BUSQUEDA_VACIOS, re);
			//throw re;
		} catch(Exception e) {
			log.error(MessageError.EC_EXCEPCION_GENERAL, e);
			//throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}
	
}
