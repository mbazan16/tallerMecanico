package com.practica.tallerMecanico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente{
	@Id
	@Column(name="id_cliente")
	private long id_cliente;
	@Column(name="documento")
	private String documento;
	@Column(name="nombre")
	private String nombre;
	@Column(name="telefono")
	private String telefono;
}
