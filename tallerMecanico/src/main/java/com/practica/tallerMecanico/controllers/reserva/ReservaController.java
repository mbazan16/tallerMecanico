package com.practica.tallerMecanico.controllers.reserva;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.tallerMecanico.common.ReservaEstado;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.services.reserva.IReservasServicio;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ReservaController {
	
	@Autowired
	IReservasServicio servicio;
	
	@PostMapping
	public String crearReserva(Model model, Reserva reserva) {
		log.info("[crearReserva]");
		log.debug("[Reserva: "+reserva.toString()+"]");
		
		servicio.crearReserva(reserva);
		model.addAttribute("reserva", reserva);
		listaReservas(model);
		return "reserva";//dirige a una template igual pero con los campos del formulario de creacion de reserva rellenados con los datos de la reserva creada
	}
	
	@PutMapping
	public String modificarReserva(Model model, Reserva reserva) {
		log.info("[modificarReserva]");
		log.debug("[modificarReserva: "+reserva.toString()+"]");
		
		servicio.modificarReserva(reserva);
		model.addAttribute("reserva", reserva);
		listaReservas(model);
		return "reserva";//dirige a una template igual pero con los campos del formulario de creacion de reserva rellenados con los datos de la reserva modificada
	}
	
	@PutMapping("/a")
	public String anularReserva(Model model,Integer id, Reserva reserva) {
		log.info("[anularReserva]");
		log.debug("[anularReserva: "+id+reserva.toString()+"]");
		
		servicio.anularReserva(reserva);
		model.addAttribute("reserva", reserva);
		listaReservas(model);
		return "reserva";//dirige a una template igual pero con los campos del formulario de creacion de reserva rellenados con los datos de la reserva modificada
	}
	
	@GetMapping
	public String mostrarLista(Model model){
		log.info("[mostrarLista]");
		
		listaReservas(model);
		return "reserva";
	}

	@GetMapping("/b")
	public String buscarReservas(Model model,@RequestParam Date fecha,@RequestParam ReservaEstado estado,@RequestParam String matricula,@RequestParam String telefono){
		log.info("[mostrarLista]");
		
		List<Reserva> reservas = servicio.buscar(fecha, estado, matricula, telefono);
		model.addAttribute("listaReservas", reservas);//modify attribute??
		return "reserva";
	}

	private void listaReservas(Model model) {
		List<Reserva> reservas = servicio.listarReservas();
		model.addAttribute("listaReservas", reservas);
	}
}
