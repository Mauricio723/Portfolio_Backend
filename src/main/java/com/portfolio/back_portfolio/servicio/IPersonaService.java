package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Persona;

public interface IPersonaService {
	
	public List<Persona> getPersonas();
	public void savePersona(Persona personaSaved);
	public void deletePersona(Long id);
	public Persona findPersona(Long id);

}
