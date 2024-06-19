package com.practica.tallerMecanico.dto;

import java.time.LocalDateTime;

public class TrabajoItem {
	
	private String id_trabajo;
	private String documento;
	private String matricula;
	private LocalDateTime fechaProgram;
	private Integer prioridad;
	
	public String getId_trabajo() {
		return id_trabajo;
	}
	public void setId_trabajo(String id_trabajo) {
		this.id_trabajo = id_trabajo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDateTime getFechaProgram() {
		return fechaProgram;
	}
	public void setFechaProgram(LocalDateTime fechaProgram) {
		this.fechaProgram = fechaProgram;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
	@Override
	public String toString() {
		return "TrabajoItem [id_trabajo=" + id_trabajo + ", documento=" + documento + ", matricula=" + matricula
				+ ", fechaProgram=" + fechaProgram + ", prioridad=" + prioridad + "]";
	}
}
