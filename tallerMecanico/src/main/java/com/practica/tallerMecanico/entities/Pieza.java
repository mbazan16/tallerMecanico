package com.practica.tallerMecanico.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Pieza {

	@Id
	private int id;	
	private String nombre;
	private String codigo;
	private float precio;
	
	public Pieza(int id, String nombre, float precio) {
		this.id= id;
		this.nombre = nombre;
		this.precio=precio;
	}	
}
