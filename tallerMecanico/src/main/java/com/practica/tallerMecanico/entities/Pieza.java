package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Pieza {

	@Id
	private int id;	
	private float precio;
	
	public Pieza(int id, float precio) {
		this.id= id;
		this.precio=precio;
	}
	
}
