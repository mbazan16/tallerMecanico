package com.practica.tallerMecanico.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PKPiezasTrabajo {
	
	@ManyToOne
	@JoinColumn(name = "id_pieza")
	private Pieza pieza;
	
	@ManyToOne
	@JoinColumn(name = "id_trabajo")
	private Trabajo trabajo;

	
}
