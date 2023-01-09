package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Persona;
import com.portfolio.back_portfolio.repositorio.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaRepository repoPersona;

	@Override
	public List<Persona> getPersonas() {
		List<Persona> listaPersonas = repoPersona.findAll();
		return listaPersonas;
	}

	@Override
	public void savePersona(Persona personaSaved) {
		repoPersona.save(personaSaved);
	}

	@Override
	public void deletePersona(Long id) {
		repoPersona.deleteById(id);
	}

	@Override
	public Persona findPersona(Long id) {
		return repoPersona.findById(id).orElse(null);		
	}

}
