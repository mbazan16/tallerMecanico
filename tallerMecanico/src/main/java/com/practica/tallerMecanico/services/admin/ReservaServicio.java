package com.practica.tallerMecanico.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.Utility;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservaServicio implements IAdmin<Reserva> {

	Logger log = LoggerFactory.getLogger(ReservaServicio.class);

	@Autowired
	ReservaRepository reservaRepository;

	@Override
	public List<Reserva> getPendientes() throws ServiceException {
		List<Reserva> reservas = new ArrayList<>();

		try {
			if(reservaRepository!=null) 
			{
				reservas = reservaRepository.findAll();
			}
		} catch (Exception e) {
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}

	@Override
	public List<Reserva> buscador(String matricula, String telefone) throws ServiceException {

		List<Reserva> reservas = new ArrayList<>();

		try {
			for (Reserva reserva : reservaRepository.findAll()) {
				if(Utility.isNullOrEmptyOrBlank(matricula) || Utility.isNullOrEmptyOrBlank(telefone)) {
					
					if(reserva.getCoche().getMatricula().equals(matricula) || reserva.getCliente().getTelefono().equals(telefone)) {
						reservas.add(reserva);
					}
					else {
						//Matricula o Telefone no estan existe en la Repo
					}
				}
				else {
					//Continar
				}
			}
		} catch (Exception e) {
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return reservas;
	}

	public void recepcion() {
		// TODO
		// Reserva - Trabajo
		// Cambiar Estado Reverva
		// Generar trabajo
		
		//Reserva currentReserva = reservaRepository.();
	}

	public void ver() {
		// TODO
	}
	
}
