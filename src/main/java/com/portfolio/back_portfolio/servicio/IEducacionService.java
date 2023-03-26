package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Educacion;

public interface IEducacionService {

	public List<Educacion> getEducaciones();
	public void saveEducacion(Educacion educacionSaved);
	public void deleteEducacion(Integer id);
	public Educacion findEducacion(Integer id);
		
}
