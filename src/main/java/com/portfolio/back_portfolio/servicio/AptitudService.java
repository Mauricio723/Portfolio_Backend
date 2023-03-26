package com.portfolio.back_portfolio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.modelo.Aptitud;
import com.portfolio.back_portfolio.repositorio.AptitudRepository;

@Service
public class AptitudService implements IAptitudService {

	@Autowired
	private AptitudRepository repoAptitud;

	@Override
	public List<Aptitud> getAptitudes() {
		List<Aptitud> listaAptitudes = repoAptitud.findAll();
		return listaAptitudes;
	}

	@Override
	public void saveAptitud(Aptitud aptitudSaved) {
		repoAptitud.save(aptitudSaved);		
	}

	@Override
	public void deleteAptitud(Integer id) {
		repoAptitud.deleteById(id);		
	}

	@Override
	public Aptitud findAptitud(Integer id) {
		Aptitud aptitudFind = repoAptitud.findById(id).orElse(null);
		return aptitudFind;
	}
		
}
