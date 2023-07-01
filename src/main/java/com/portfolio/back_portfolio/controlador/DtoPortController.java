package com.portfolio.back_portfolio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.dto.PersonaDTO;
import com.portfolio.back_portfolio.modelo.Persona;
import com.portfolio.back_portfolio.servicio.PersonaService;

@RestController
@RequestMapping("/myapi")
public class DtoPortController {
	
	@Autowired
	private PersonaService servicioPersona;
		
	@GetMapping("/persona_dto/traer/{id_persona}")
	@ResponseBody
	public PersonaDTO obtenerPersonaDto(@PathVariable Long id_persona) {
		
		Persona persona = servicioPersona.findPersona(id_persona);
		
		PersonaDTO dtoPersona = new PersonaDTO();
		
		dtoPersona.setId(persona.getId());
		dtoPersona.setNombre(persona.getNombre());
		dtoPersona.setApellido(persona.getApellido());
		dtoPersona.setTituloPrincipal(persona.getTituloPrincipal());
		dtoPersona.setOcupacion(persona.getOcupacion());
		dtoPersona.setEmail(persona.getEmail());
		dtoPersona.setAcercaDe(persona.getAcercaDe());
		dtoPersona.setUrlFoto(persona.getUrlFoto());
		dtoPersona.setUrlBanner(persona.getUrlBanner());
		dtoPersona.setCiudad(persona.getCiudad().getNombre());
		dtoPersona.setProvincia(persona.getCiudad().getProvincia());
		dtoPersona.setPais(persona.getCiudad().getPais());
		
		return dtoPersona;
		
	}
		
}
