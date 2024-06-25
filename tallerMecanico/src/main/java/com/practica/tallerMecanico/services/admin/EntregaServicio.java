package com.practica.tallerMecanico.services.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.Utility;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaServicio implements IAdmin<Entrega> {

	Logger log = LoggerFactory.getLogger(ReservaServicio.class);
	
	@Autowired
	EntregaRepository entregaRepository;
	
	@Override
	public List<Entrega> buscador(String matricula, String telefone) throws ServiceException {
		
		List<Entrega> entregas = new ArrayList<>();

		try {
			for (Entrega entrega : entregaRepository.findAll()) {
				if(Utility.isNullOrEmptyOrBlank(matricula) || Utility.isNullOrEmptyOrBlank(telefone)) {
					
					if(entrega.getCoche().getMatricula().equals(matricula) || entrega.getCliente().getTelefono().equals(telefone)) {
						entregas.add(entrega);
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
		return entregas;
		
	}

	@Override
	public List<Entrega> getPendientes() throws ServiceException {
		List<Entrega> entregas = new ArrayList<>();

		try {
			if(entregaRepository!=null) 
			{
				entregas = entregaRepository.findAll();
			}
		} catch (Exception e) {
			throw new ReservaException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return entregas;
	}
	
	public void entregar() {
		
	}

	public void verTrabajo() {
		
	}
}
