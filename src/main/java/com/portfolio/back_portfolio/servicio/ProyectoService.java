package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Proyecto;
import com.portfolio.back_portfolio.repositorio.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService {

	@Autowired
	private ProyectoRepository repoProyecto;

	@Override
	public List<Proyecto> getProyectos() {
		List<Proyecto> listaProyectos = repoProyecto.findAll();
		return listaProyectos;
	}

	@Override
	public void saveProyecto(Proyecto proyectoSaved) {
		repoProyecto.save(proyectoSaved);		
	}

	@Override
	public void deleteProyecto(Integer id) {
		repoProyecto.deleteById(id);		
	}

	@Override
	public Proyecto findProyecto(Integer id) {
		Proyecto proyectoFind = repoProyecto.findById(id).orElse(null);
		return proyectoFind;
	}	
	
}
