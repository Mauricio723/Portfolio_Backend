package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Trabajo;
import com.portfolio.back_portfolio.repositorio.TrabajoRepository;

@Service
public class TrabajoService implements ITrabajoService {

	@Autowired
	private TrabajoRepository repoTrabajo;

	@Override
	public List<Trabajo> getTrabajos() {
		List<Trabajo> listaTrabajos = repoTrabajo.findAll();
		return listaTrabajos;
	}

	@Override
	public void saveTrabajo(Trabajo trabajoSaved) {
		repoTrabajo.save(trabajoSaved);		
	}

	@Override
	public void deleteTrabajo(Integer id) {
		repoTrabajo.deleteById(id);		
	}

	@Override
	public Trabajo findTrabajo(Integer id) {
		Trabajo trabajoFind = repoTrabajo.findById(id).orElse(null);
		return trabajoFind;
	}	
	
}
