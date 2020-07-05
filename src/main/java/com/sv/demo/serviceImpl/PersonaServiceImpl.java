package com.sv.demo.serviceImpl;

/**
 * Se implementan los metodos generado en el service para crear logica adecuda
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.demo.dao.IPersonaDao;
import com.sv.demo.model.Persona;
import com.sv.demo.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	/**
	 * Se hace inyeccion de dependencia para agregar las funciones de la interface dao para manipular data
	 */
	@Autowired
	private IPersonaDao dao;

	@Override
	public List<Persona> listaPersona() {
		return dao.findPersonasByEstado(1);
	}

	@Override
	public Persona persona(Long idPersona) {
		return dao.findById(idPersona).orElse(null);
	}

	@Override
	public int guardarPersona(Persona persona) {
		int rpta = 0;
		rpta = (int) (dao.save(persona) != null ? persona.getIdPersona() : 0);
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int actualizarPersona(Persona persona) {
		int rpta = 0;
		rpta = (int) (dao.save(persona) != null ? persona.getIdPersona() : 0);
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int eliminarPersona(Long Persona) {
		Persona p = dao.findById(Persona).orElse(null);
		int rpta = 0;
		p.setEstado(0);
		rpta = (int) (dao.save(p) != null ? p.getIdPersona() : 0);
		return rpta > 0 ? 1 : 0;
	}

}
