package com.practica.tallerMecanico.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.repositories.ReservaRepository;
import com.practica.tallerMecanico.services.admin.EntregaServicio;
import com.practica.tallerMecanico.services.admin.ReservaServicio;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.reserva.IReservasServicio;
import com.practica.tallerMecanico.services.reserva.exception.ReservaException;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	@Autowired
	ReservaServicio reservaServicio;

	@Autowired
	EntregaServicio entregaServicio;

	@GetMapping
	public String mostrarPaginaAdministracion(Model model) throws ServiceException {

		List<Reserva> reservaPendiente = getReservaPendientes();

		List<Entrega> entregaPendiente = getEntregaPendientes();

		model.addAttribute("reservaPendiente", reservaPendiente);
		model.addAttribute("entregaPendiente", entregaPendiente);

		return "admin";
	}

	
	private List<Reserva> getReservaPendientes() throws ServiceException {
		List<Reserva> reservas = new ArrayList<>();
		reservas = reservaServicio.getPendientes();
		return reservas;
	}
	
	
	private List<Entrega> getEntregaPendientes() throws ServiceException {
		List<Entrega> entregas = new ArrayList<>();
		entregas = entregaServicio.getPendientes();
		return entregas;
	}
	
	
}