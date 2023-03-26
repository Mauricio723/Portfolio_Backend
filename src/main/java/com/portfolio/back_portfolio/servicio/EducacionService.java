package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Educacion;
import com.portfolio.back_portfolio.repositorio.EducacionRepository;

@Service
public class EducacionService implements IEducacionService {

	@Autowired
	private EducacionRepository repoEducacion;

	@Override
	public List<Educacion> getEducaciones() {
		List<Educacion> listaEducaciones = repoEducacion.findAll();
		return listaEducaciones;
	}

	@Override
	public void saveEducacion(Educacion educacionSaved) {
		repoEducacion.save(educacionSaved);		
	}

	@Override
	public void deleteEducacion(Integer id) {
		repoEducacion.deleteById(id);		
	}

	@Override
	public Educacion findEducacion(Integer id) {
		Educacion educacionFind = repoEducacion.findById(id).orElse(null);
		return educacionFind;
	}
	
}
