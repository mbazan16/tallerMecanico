package com.practica.tallerMecanico.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Entrega;


public interface EntregaRepository extends JpaRepository<Entrega, Integer> {


    List<Entrega> findAllByFechaRecogida(LocalDateTime fechaRecogida);

    List<Entrega> findAllByCoche(Coche coche);

    List<Entrega> findAllByCliente(Cliente cliente);

}
