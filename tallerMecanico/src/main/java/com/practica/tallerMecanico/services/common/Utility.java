package com.practica.tallerMecanico.services.common;

public abstract class Utility {
	
	public static boolean isNullOrEmptyOrBlank(String str) {
		return ( !str.isBlank() && str.length() > 0);
	}

}
