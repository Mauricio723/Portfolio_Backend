package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Ciudad;

public interface ICiudadService {

	public List<Ciudad> getCiudades();
	public void saveCiudad(Ciudad ciudadSaved);
	public void deleteCiudad(Long id);
	public Ciudad findCiudad(Long id);
	
}
