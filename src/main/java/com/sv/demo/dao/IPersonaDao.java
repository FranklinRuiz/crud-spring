package com.sv.demo.dao;

/**
 * Interface para interactuar con las tablas de base de datos 
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.demo.model.Persona;

@Repository
public interface IPersonaDao extends JpaRepository<Persona, Long> {

	/**
	 * Se puede crear metodos personalizados para filtar los datos de las tablas
	 * @param estado filtar los registros con estado 1 = activo 0 = eliminado
	 * @return Lista de datos activos
	 */
	List<Persona> findPersonasByEstado(int estado);

}
