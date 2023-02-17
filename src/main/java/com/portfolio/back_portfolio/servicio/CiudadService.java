package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Ciudad;
import com.portfolio.back_portfolio.repositorio.CiudadRepository;

@Service
public class CiudadService implements ICiudadService {

	@Autowired
	private CiudadRepository repoCiudad;

	@Override
	public List<Ciudad> getCiudades() {
		List<Ciudad> listaCiudades = repoCiudad.findAll();
		return listaCiudades;
	}

	@Override
	public void saveCiudad(Ciudad ciudadSaved) {
		repoCiudad.save(ciudadSaved);		
	}

	@Override
	public void deleteCiudad(Long id) {
		repoCiudad.deleteById(id);		
	}

	@Override
	public Ciudad findCiudad(Long id) {
		Ciudad ciudadFind = repoCiudad.findById(id).orElse(null);
		return ciudadFind;
	}	
	
}
