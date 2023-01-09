package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Aptitud;
import com.portfolio.back_portfolio.servicio.IAptitudService;

@RestController
public class AptitudController {

	@Autowired
	private IAptitudService interfAptitudService;
	
	@GetMapping("/aptitudes/traer_todas")
	public List<Aptitud> traerAptitudes() {
		List<Aptitud> listaAptitudes = interfAptitudService.getAptitudes();
		return listaAptitudes;
	}
	
	@PostMapping("/aptitudes/crear")
	public void crearAptitud(@RequestBody Aptitud aptitudCreada) {
		interfAptitudService.saveAptitud(aptitudCreada);
	}
	
}
