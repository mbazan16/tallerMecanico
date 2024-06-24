package com.practica.tallerMecanico.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    
	
	//DashBoard
	@Query("select t from Trabajo t where t.estado= :estado order by t.prioridad")
    List<Trabajo> findAllByEstado(EstadoTrabajo estado); // Busqueda por estado 
     
    @Query("select t from Trabajo t where t.estado= :estado and t.coche.matricula= :matricula order by t.prioridad")
    List<Trabajo> findAllByEstadoAndMatricula(EstadoTrabajo estado,String matricula); // Busqueda por estado 
    
    @Query("select t from Trabajo t where t.estado= :estado and t.cliente.telefono= :telefono order by t.prioridad")
    List<Trabajo> findAllByEstadoAndTelefono(EstadoTrabajo estado,String telefono); // Busqueda por estado 
    
    @Query("select t from Trabajo t where t.fechaProgramacion= :fechaInicio order by t.prioridad")
    List<Trabajo> findAllByFProgramacionAndEstado(EstadoTrabajo estado,LocalDate fechaProgramacion); //Busqueda por fecha de programacion listo
   
    @Query("select t from Trabajo t where t.fechaProgramacion= :fechaInicio  order by t.prioridad")
    List<Trabajo> findAllByFProgramacion(LocalDate fechaProgramacion); //Busqueda por fecha de programacion listo
   
    @Query("select t from Trabajo t where t.fechaProgramacion= :fechaInicio and t.coche.matricula= :matricula order by t.prioridad")
    List<Trabajo> findAllByFProgramacionAndMatricula(LocalDate fechaProgramacion,String matricula); //Busqueda por fecha de programacion listo
   
    @Query("select t from Trabajo t where t.fechaProgramacion= :fechaInicio and t.cliente.telefono= :telefono order by t.prioridad")
    List<Trabajo> findAllByFProgramacionAndTelefono(LocalDate fechaProgramacion,String telefono); //Busqueda por fecha de programacion listo 
    
    //Ficha Coche
    @Query("select t from Trabajo t where t.coche.matricula= :matricula order by t.fechaInicio desc, t.prioridad")
    List<Trabajo> findAllByMatricula(String matricula); //Histórico por matrícula
    
    //Ficha Coche
    @Query("select t from Trabajo t where t.cliente.id= :id order by t.fechaInicio desc, t.prioridad")
    List<Trabajo> findAllByCliente(@Param("id")Long idCliente); //Trabajos por cliente

    // Nuevas querys 24/06/2024
    
  
    @Query("SELECT t FROM Trabajo t WHERE t.cocheId = :cocheId AND t.fechaInicio = :fechaInicio")
    List<Trabajo> findAllByCocheIdAndFechaInicio(@Param("cocheId") Long cocheId, @Param("fechaInicio") LocalDate fechaInicio); // Busqueda por fecha de inicio FechaInicio CocheId.FindAllByCocheIdAndFechaInicio 

    @Query("SELECT t FROM Trabajo t WHERE t.coche.id = :cocheId")
    List<Trabajo> findAllByCocheId(@Param("cocheId") Long cocheId); // CocheId findAllByCocheId
    
    @Query("SELECT t FROM Trabajo t WHERE t.coche.id = :cocheId AND t.coche.tipo = :tipo")
    List<Trabajo> findAllByCocheIdAndCocheTipo(@Param("cocheId") Long cocheId, @Param("tipo") String tipo); // Tipo FindAllByCocheIDTipo
     
}




