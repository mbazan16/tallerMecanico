package com.practica.tallerMecanico.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String documento;
	private String nombre;
	private String telefono;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Cliente-Coche",
	joinColumns=@JoinColumn(name="idCliente"),
	inverseJoinColumns=@JoinColumn(name="idCoche"))
	private Set<Coche> coches;
	
}
