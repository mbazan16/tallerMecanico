package com.practica.tallerMecanico.services.common;

public class ReservaException extends ServiceException {

	String code;
	public ReservaException(String code) {
		super(code);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
