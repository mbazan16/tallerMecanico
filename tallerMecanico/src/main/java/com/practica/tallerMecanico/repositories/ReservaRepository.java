package com.practica.tallerMecanico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.common.ReservaEstado;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Cliente;
import java.util.List;
import java.util.Date;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findAllByCoche(Coche coche);

    List<Reserva> findAllByCliente(Cliente cliente);

    List<Reserva> findAllByReservaEstado(ReservaEstado reservaEstado);

    List<Reserva> findByCocheAndFechaReserva(Coche coche, Date fechaReserva);
}
