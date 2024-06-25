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
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.entrega.exception.EntregaException;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServicio implements IAdminServicio{

	Logger log = LoggerFactory.getLogger(AdminServicio.class);
	
	@Autowired
	EntregaRepository entregaRepository;
	
	@Autowired
	ReservaRepository reversaRepository;
	
	
	@Override
	public List<Reserva> getReservaPendientes() throws ReservaException {
		List<Reserva> reservas = new ArrayList<>();
		
		try {
			//reservas.forEach(()->{});
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reservas;
	}

	@Override
	public List<Entrega> getEntregaPendientes() throws EntregaException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<IBuscar<Reserva, ServiceException>> buscadorReserva(String matricula, String telefone) throws ServiceException{
		
		return null;
	}

	@Override
	public List<IBuscar<Entrega, ServiceException>> buscadorEntrega(String matricula, String telefone)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Recepcionar(Reserva resvera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Ver() {
		// TODO Auto-generated method stub
		
	}
}
