package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Trabajo;

public interface ITrabajoService {

	public List<Trabajo> getTrabajos();
	public void saveTrabajo(Trabajo trabajoSaved);
	public void deleteTrabajo(Integer id);
	public Trabajo findTrabajo(Integer id);
	
}
