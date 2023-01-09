package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Ciudad;
import com.portfolio.back_portfolio.servicio.ICiudadService;

@RestController
public class CiudadController {

	@Autowired
	private ICiudadService interfCiudadService;
	
	@GetMapping("/ciudades/traer_todas")
	public List<Ciudad> getCiudad() {
		return interfCiudadService.getCiudades();
	}
	
	@PostMapping("/ciudades/crear")
	public void crearCiudad(@RequestBody Ciudad ciudadCreada) {
		interfCiudadService.saveCiudad(ciudadCreada);
	}
	@DeleteMapping("/ciudades/eliminar/{id}")
	public void eliminarCiudad(@PathVariable Integer id) {
		interfCiudadService.deleteCiudad(id);
	}
}
