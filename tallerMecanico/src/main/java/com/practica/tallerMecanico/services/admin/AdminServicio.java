package com.practica.tallerMecanico.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.entrega.exception.EntregaException;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServicio implements IAdminServicio{

	@Autowired
	EntregaRepository entregaRepository;
	
	@Autowired
	ReservaRepository reversaRepository;
	
	
	@Override
	public List<Reserva> getReservaPendientes() throws ReservaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entrega> getEntregaPendientes() throws EntregaException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Reserva> buscadorReserva(String matricula, String telefone) throws ServiceException{
		
		return null;
	}

	@Override
	public List<Entrega> buscadorEntrega(String matricula, String telefone) throws ServiceException{
		// TODO Auto-generated method stub
		return null;
	}



}
