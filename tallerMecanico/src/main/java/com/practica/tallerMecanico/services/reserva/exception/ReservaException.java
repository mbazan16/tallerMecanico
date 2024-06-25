package com.practica.tallerMecanico.services.reserva.exception;

public class ReservaException extends Exception {
	String code;
	public ReservaException(String code) {
		super(code);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
