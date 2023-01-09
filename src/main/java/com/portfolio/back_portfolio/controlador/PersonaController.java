package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Persona;
//import com.portfolio.back_portfolio.servicio.ICiudadService;
import com.portfolio.back_portfolio.servicio.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService interfPersonaService;
	
	//@Autowired
	//private ICiudadService interfCiudadService;
	
	@GetMapping("/personas/traer_todas")
	public List<Persona> getPersonas() {
		return interfPersonaService.getPersonas();
	}
	
	@PostMapping("/personas/crear")
	public void creaarPersona(@RequestBody Persona personaCreada) {
		
		interfPersonaService.savePersona(personaCreada);
	}
	
	@DeleteMapping("/personas/eliminar/{id}")
	public void eliminarPersona(@PathVariable Long id) {
		interfPersonaService.deletePersona(id);
	}
	
}
