package com.practica.tallerMecanico.services.common;

public class MessageError {

	public static final String EC_EXCEPCION_GENERAL="error.general";

	public static final String EC_EXCEPCION_NO_ID="error.noid.introducido";	
	//Mensajes de error reserva
	public static final String EC_EXCEPCION_RESERVA_NO_EXISTE="error.reserva.noExiste"; //"La reserva no existe."
	
	public static final String EC_EXCEPCION_CREAR_RESERVA="error.reserva.crear";//"Error al guardar la reserva."
	
	public static final String EC_EXCEPCION_ANULAR_RESERVA="error.reserva.anular"; //"Esta reserva ya esta anulada o ejecutada."
	
	public static final String EC_EXCEPCION_RESERVAS_SIN_ELEMENTOS="error.reserva.sinElementos";//"No hay elementos con esos criterio de busqueda."
	
	public static final String EC_EXCEPCION_CAMPOS_BUSQUEDA_VACIOS="error.reserva.camposVacios"; //"Rellene al menos un campo de busqueda."

}
