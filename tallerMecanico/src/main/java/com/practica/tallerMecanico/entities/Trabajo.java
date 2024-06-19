package com.practica.tallerMecanico.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trabajo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipo;
	private String descripcion;
	private int horas;
	private EstadoTrabajo estado;
	private int prioridad;
	private LocalDateTime fechaProgramacion;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private LocalDateTime fechaEntrega;
	private LocalDateTime fechaRecogida;
	private String observaciones;
	private int kmEntrada;
	private int kmSalida;
	private boolean marcaObservacion;
	private float precio;
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
