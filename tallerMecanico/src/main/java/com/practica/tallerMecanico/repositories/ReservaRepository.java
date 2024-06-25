package com.practica.tallerMecanico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.tallerMecanico.entities.Reserva;
import com.practica.tallerMecanico.common.ReservaEstado;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Cliente;
import java.util.List;
import java.util.Date;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findAllByCocheMatricula(String matricula);

    List<Reserva> findAllByCliente(String telefono);

    List<Reserva> findAllByReservaEstado(ReservaEstado reservaEstado);

    List<Reserva> findByFechaReserva( Date fechaReserva);
}
