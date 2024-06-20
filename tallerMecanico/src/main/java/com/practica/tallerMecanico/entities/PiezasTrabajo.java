package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PKPiezasTrabajo.class)
public class PiezasTrabajo {

	@Id
	private Pieza pieza;
	@Id
	private Trabajo trabajo;
	private int cantidad;
	
	
}
