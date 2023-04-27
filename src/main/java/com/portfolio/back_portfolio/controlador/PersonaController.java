package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Persona;
import com.portfolio.back_portfolio.servicio.ICiudadService;
import com.portfolio.back_portfolio.servicio.IPersonaService;

@RestController
@RequestMapping("myapi/personas")
public class PersonaController {

	@Autowired
	private IPersonaService intPersonaService;
	
	@Autowired
	private ICiudadService intCiudadService;
		
	@GetMapping("/traer_todas")
	public List<Persona> getPersonas() {
		return intPersonaService.getPersonas();
	}
	
	@PostMapping("/crear/{id_ciudad}")
	public void creaarPersona(@RequestBody Persona personaCreada, @PathVariable Long id_ciudad) {		
		personaCreada.setCiudad(intCiudadService.findCiudad(id_ciudad));
		intPersonaService.savePersona(personaCreada);
	}
			
	@GetMapping("/traer/{id}")
	public Persona traerPersona(@PathVariable Long id) {		
		return intPersonaService.findPersona(id);
	}
	
	@PutMapping("/modificar/{id_persona}/{id_ciudad}")
	public void modificarPersona (@RequestBody Persona personaParaModificar,
			                      @PathVariable Long id_persona, 
			                      @PathVariable Long id_ciudad) {
		
		Persona personaModificada = intPersonaService.findPersona(id_persona);
		
		personaModificada.setNombre(personaParaModificar.getNombre());
		personaModificada.setApellido(personaParaModificar.getApellido());
		personaModificada.setOcupacion(personaParaModificar.getOcupacion());
		personaModificada.setTituloPrincipal(personaParaModificar.getTituloPrincipal());
		personaModificada.setFechaNacimiento(personaParaModificar.getFechaNacimiento());
		personaModificada.setDocumento(personaParaModificar.getDocumento());
		personaModificada.setEmail(personaParaModificar.getEmail());
		personaModificada.setAcercaDe(personaParaModificar.getAcercaDe());
		personaModificada.setUrlFoto(personaParaModificar.getUrlFoto());
		personaModificada.setUrlBanner(personaParaModificar.getUrlBanner());
		
		personaModificada.setCiudad(intCiudadService.findCiudad(id_ciudad));
				
		intPersonaService.savePersona(personaModificada);				
	}
		
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPersona(@PathVariable Long id) {
		intPersonaService.deletePersona(id);
	}
	
}
