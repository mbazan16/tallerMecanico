package com.practica.tallerMecanico.services.admin;

import java.util.List;

public interface IBuscar<T,E extends Exception> {

	public List<T> buscador (String matricula, String telefone) throws E;
}
