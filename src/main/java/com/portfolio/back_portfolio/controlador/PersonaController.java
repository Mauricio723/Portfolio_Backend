package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/personas/traer/{id}")
	public Persona traerPersona(@PathVariable Long id) {		
		return interfPersonaService.findPersona(id);
	}
	
	@PutMapping("/personas/modificar/{id}")
	public String modificarPersona (@PathVariable Long id, @RequestBody Persona personaParaModificar) {
		Persona personaModificada = interfPersonaService.findPersona(id);
		personaModificada.setNombre(personaParaModificar.getNombre());
		personaModificada.setApellido(personaParaModificar.getApellido());
		personaModificada.setOcupacion(personaParaModificar.getOcupacion());
		personaModificada.setFecha_nacimiento(personaParaModificar.getFecha_nacimiento());
		personaModificada.setDocumento(personaParaModificar.getDocumento());
		personaModificada.setEmail(personaParaModificar.getEmail());
		personaModificada.setAcerca_de(personaParaModificar.getAcerca_de());
		personaModificada.setUrlFoto(personaParaModificar.getUrlFoto());
		personaModificada.setUrlBanner(personaParaModificar.getUrlBanner());
		
		interfPersonaService.savePersona(personaModificada);
		
		return "Persona modificada con id: " + id;
	}
	
	@PostMapping("/personas/prueba_crear")
	public void crearPersonaPrueba() {
		
		Persona nuevaPersona = new Persona(
				(long) 0, "Salvador Mauricio", 
				"Vilches Jerez", 
				"Estudiante", 
				"30/05/1972", 
				"92401924", 
				"salvadorvilches1972@gmail.com", 
				"Texto acerca de Mauricio", 
				"url foto de Mauricio", 
				"url de banner del portfolio");
		
		interfPersonaService.savePersona(nuevaPersona);
		
	}
	
	@DeleteMapping("/personas/eliminar/{id}")
	public void eliminarPersona(@PathVariable Long id) {
		interfPersonaService.deletePersona(id);
	}
	
}
