package com.practica.tallerMecanico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coche")
public class Coche{
	@Id
	@Column(name="id_coche")
	private long id_coche;
	@Column(name="matricula")
	private String matricula;
	@Column(name="kilometraje")
	private Integer kilometraje;
	@Column(name="marca")
	private int marca;
	@Column(name="modelo")
	private int modelo;
}
