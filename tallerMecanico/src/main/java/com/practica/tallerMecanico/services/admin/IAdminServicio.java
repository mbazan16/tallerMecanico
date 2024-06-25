package com.practica.tallerMecanico.services.admin;

import java.util.List;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.entrega.exception.EntregaException;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

public interface IAdminServicio {
	
	public List<Reserva> getReservaPendientes()throws ReservaException;
	
	public List<Entrega> getEntregaPendientes()throws EntregaException;
	
	public List<IBuscar<Entrega,ServiceException>> buscadorEntrega (String matricula, String telefone) throws ServiceException;
	
	public List<IBuscar<Reserva,ServiceException>> buscadorReserva (String matricula, String telefone) throws ServiceException;
	
	public void Recepcionar(Reserva resvera);
	
	public void Ver();

}
