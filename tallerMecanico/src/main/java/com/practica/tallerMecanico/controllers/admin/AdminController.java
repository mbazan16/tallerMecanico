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
import com.practica.tallerMecanico.services.reserva.IReservasServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	@Autowired
	IReservasServicio reservaS;

	@Autowired
	EntregaRepository entregaRepository;

	@GetMapping("/admin")
	public String mostrarPaginaAdministracion(Model model) {

		List<Reserva> reservaPendiente = getReservaPendientes();

		List<Entrega> entregaPendiente = getEntregaPendientes();

		model.addAttribute("reservaPendiente", reservaPendiente);
		model.addAttribute("entregaPendiente", entregaPendiente);

		return "admin";
	}

	@GetMapping("/admin")
	public List<Reserva> getReservaPendientes() {
		List<Reserva> reservas = new ArrayList<>();

		return reservas;
	}
	
	@GetMapping("/admin")
	public List<Entrega> getEntregaPendientes() {
		List<Entrega> entregas = new ArrayList<>();
		return entregas;
	}
}