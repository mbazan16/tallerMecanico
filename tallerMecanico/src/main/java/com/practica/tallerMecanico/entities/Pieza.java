package com.practica.tallerMecanico.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Pieza {

	@Id
	private int id;	
	private String nombre;
	private float precio;
	
	public Pieza(int id, String nombre, float precio) {
		this.id= id;
		this.nombre = nombre;
		this.precio=precio;
	}
	
	@ManyToMany(mappedBy = "piezas")
    private Set<Trabajo> trabajos;
	
}
