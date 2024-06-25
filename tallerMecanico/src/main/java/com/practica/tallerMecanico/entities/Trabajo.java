package com.practica.tallerMecanico.entities;

import java.time.LocalDateTime;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.common.Prioridad;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private String descripcion;
	private int horas;
	private EstadoTrabajo estado;
	private Prioridad prioridad;
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
	
	
	@ManyToOne
	private TipoTrabajo tipo;
	
	@ManyToOne	
	private Mecanico mecanico;
	
	@ManyToOne	
	private Coche coche;
	
	@ManyToOne	
	private Cliente cliente;
	

	
	
	
	
	
	
	
	
	
	
	

	
	
}
