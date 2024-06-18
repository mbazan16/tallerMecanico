package com.practica.tallerMecanico.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="MECANICO")
public class Mecanico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MECANICO_ID")
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="COSTE_HORA")
	private Double costeHora;
	@OneToMany(mappedBy = "mecanico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Trabajo> trabajos = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Double getCosteHora() {
		return costeHora;
	}
	public void setCosteHora(Double costeHora) {
		this.costeHora = costeHora;
	}
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}


}
