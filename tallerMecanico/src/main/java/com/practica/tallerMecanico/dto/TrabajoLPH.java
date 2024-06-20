package com.practica.tallerMecanico.dto;

import java.time.LocalDateTime;

import com.practica.tallerMecanico.common.Prioridad;
import com.practica.tallerMecanico.entities.Mecanico;
import com.practica.tallerMecanico.entities.TipoTrabajo;

public class TrabajoLPH {
	
	private int id;
	private String tipo;
	private String descripcion;
	private int horas;	
	private Prioridad prioridad;
	private LocalDateTime fechaProgramacion;
	private String observaciones;
	private boolean marcaObservacion;
	private Mecanico mecanico;
	
   
    private TipoTrabajo tipoTrabajo;

}
