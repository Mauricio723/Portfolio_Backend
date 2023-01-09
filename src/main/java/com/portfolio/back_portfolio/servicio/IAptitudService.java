package com.portfolio.back_portfolio.servicio;

import java.util.List;

import com.portfolio.back_portfolio.modelo.Aptitud;

public interface IAptitudService {

	public List<Aptitud> getAptitudes();
	public void saveAptitud(Aptitud aptitudSaved);
	public void deleteAptitud(Integer id);
	public Aptitud findAptitud(Integer id);
	
}
