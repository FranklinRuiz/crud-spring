package com.sv.demo.controller;

/**
 * Clase controller para generar y recepcionar JSON para la trama de datos
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.demo.model.Persona;
import com.sv.demo.service.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	/**
	 * Inyeccion de depencias
	 */
	@Autowired
	private IPersonaService service;

	@GetMapping("/lista")
	public ResponseEntity<List<Persona>> lista() {
		List<Persona> lista = null;
		try {
			lista = service.listaPersona();
		} catch (Exception e) {
			return new ResponseEntity<List<Persona>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/lista/{idPersona}")
	public ResponseEntity<Persona> listaId(@PathVariable("idPersona") Long idPersona) {
		Persona p = null;
		try {
			p = service.persona(idPersona);
		} catch (Exception e) {
			return new ResponseEntity<Persona>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Integer> registrar(@RequestBody Persona Persona) {
		int rpta = 0;
		try {
			rpta = service.guardarPersona(Persona);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<Integer> actualizar(@RequestBody Persona Persona) {
		int rpta = 0;
		try {
			rpta = service.guardarPersona(Persona);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@GetMapping("/eliminar/{idPersona}")
	public ResponseEntity<Integer> eliminar(@PathVariable("idPersona") Long idPersona) {
		int rpta = 0;
		try {
			rpta = service.eliminarPersona(idPersona);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

}
