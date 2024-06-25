package com.practica.tallerMecanico.services.admin;

import java.util.List;

import com.practica.tallerMecanico.services.common.ServiceException;

public interface IBuscar<T> {

	public List<T> buscador (String matricula, String telefone) throws ServiceException;
}
