package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coche{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String matricula;
	private Integer kilometraje;
	private String marca;
	private String modelo;
}
