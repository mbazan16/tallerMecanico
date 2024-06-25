package com.practica.tallerMecanico.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.entrega.exception.EntregaException;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservaServicio implements IAdmin<Reserva>{

	Logger log = LoggerFactory.getLogger(ReservaServicio.class);
	
	@Autowired
	EntregaRepository entregaRepository;
	
	@Autowired
	ReservaRepository reversaRepository;
	
	
	@Override
	public List<Reserva> getPendientes() throws ReservaException {
		List<Reserva> reservas = new ArrayList<>();
		
		try {
			//reservas.forEach(()->{});
		} catch (Exception e) {
			// TODO: handle exception
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}
	
	@Override
	public List<Reserva> buscador(String matricula, String telefone) throws ReservaException{
		
		return null;
	}

	
}
