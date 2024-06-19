package com.practica.tallerMecanico.dto;

import java.time.LocalDateTime;

public class EntregaItem {
	
	private String id_trabajo;
	private String matricula;
	private String documento;
	private LocalDateTime fechaFin;
	
	public String getId_trabajo() {
		return id_trabajo;
	}
	public void setId_trabajo(String id_trabajo) {
		this.id_trabajo = id_trabajo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String toString() {
		return "EntregaItem [id_trabajo=" + id_trabajo + ", matricula=" + matricula + ", documento=" + documento
				+ ", fechaFin=" + fechaFin + "]";
	}
	
}
