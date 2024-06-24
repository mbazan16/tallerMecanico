package com.practica.tallerMecanico.services.entrega.exception;

public class EntregaException extends Exception {
	String code;
	public EntregaException(String code) {
		super(code);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
