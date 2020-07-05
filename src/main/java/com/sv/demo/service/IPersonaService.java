package com.sv.demo.service;

/**
 * Interface para declarar los metodos que se usaran para la logica de programacion
 */
import java.util.List;

import com.sv.demo.model.Persona;

public interface IPersonaService {
	List<Persona> listaPersona();
	Persona persona(Long idPersona);
	int guardarPersona(Persona persona);
	int actualizarPersona(Persona persona);
	int eliminarPersona(Long Persona);
}
