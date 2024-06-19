package com.practica.tallerMecanico.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JOB")
public class Trabajo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private int id;
	
	@Column(name="JOB_TYPE")
	private String tipo;
	
	@Column(name="JOB_DESCRIPTION")
	private String descripcion;
	
	@Column(name="JOB_HOURS")
	private int horas;
	
	@Column(name="JOB_STATE")
	private String estado;
	
	@Column(name="JOB_PRIORITY")
	private String prioridad;
	
	@Column(name="JOB_PROGRAMING_DATE")
	private LocalDateTime fecha_programacion;
	
	@Column(name="JOB_START_DATE")
	private LocalDateTime fecha_inicio;
	
	@Column(name="JOB_END_DATE")
	private LocalDateTime fecha_fin;
	
	@Column(name="JOB_RELEASE_DATE")
	private LocalDateTime fecha_entrega;
	
	@Column(name="JOB_DATE_COLLECTION")
	private LocalDateTime fecha_recogida;
	
	@Column(name="JOB_OBSERVATIONS")
	private String observaciones;
	
	@Column(name="JOB_ENTRY_KM")
	private int kilometros_de_entrada;
	
	@Column(name="JOB_EXIT_KM")
	private int kilometros_de_salida;
	
	@Column(name="JOB_MCA_OBSERVATION")
	private Boolean marca_observacion;
	
	@Column(name="JOB_PRICE")
	private Float precio;
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
