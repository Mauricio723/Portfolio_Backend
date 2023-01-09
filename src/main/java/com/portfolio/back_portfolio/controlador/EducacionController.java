package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Educacion;
import com.portfolio.back_portfolio.servicio.IEducacionService;

@RestController
public class EducacionController {

	@Autowired
	private IEducacionService interfEducacionService;
	
	@GetMapping("/educacion/traer_todo")
	public List<Educacion> getEducacion() {
		return interfEducacionService.getEducaciones();
	}
	
	@GetMapping("/educacion/crear")
	public void crearEducacion(@RequestBody Educacion educacionCreada) {
		interfEducacionService.saveEducacion(educacionCreada);
	}
	
}
