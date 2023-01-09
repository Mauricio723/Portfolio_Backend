package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Proyecto;

public interface IProyectoService {

	public List<Proyecto> getProyectos();
	public void saveProyecto(Proyecto proyectoSaved);
	public void deleteProyecto(Integer id);
	public Proyecto findProyecto(Integer id);
	
}
