package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coche{
	private long id;
	private String matricula;
	private Integer kilometraje;
	private int marca;
	private int modelo;
}
