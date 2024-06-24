package com.practica.tallerMecanico.controllers.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practica.tallerMecanico.services.reserva.IReservasServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservaController {
	
	@Autowired
	IReservasServicio servicio;
}
