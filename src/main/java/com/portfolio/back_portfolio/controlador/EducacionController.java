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

import com.portfolio.back_portfolio.modelo.Educacion;
import com.portfolio.back_portfolio.servicio.ICiudadService;
import com.portfolio.back_portfolio.servicio.IEducacionService;
import com.portfolio.back_portfolio.servicio.IPersonaService;

@RestController
@RequestMapping("/myapi/educacion")
public class EducacionController {

	@Autowired
	private IEducacionService intEducacionService;
	
	@Autowired
	private IPersonaService intPersonaService;
	
	@Autowired
	private ICiudadService intCiudadService;
	
	@GetMapping("/traer_todo")
	public List<Educacion> getEducacion() {
		return intEducacionService.getEducaciones();
	}
	
	@PostMapping("/crear/{id_persona}/{id_ciudad}")
	public void crearEducacion(@RequestBody Educacion educacionCreada, 
			                   @PathVariable Long id_persona, 
			                   @PathVariable Long id_ciudad) {
		
		educacionCreada.setPersona(intPersonaService.findPersona(id_persona));
		educacionCreada.setCiudad(intCiudadService.findCiudad(id_ciudad));
		intEducacionService.saveEducacion(educacionCreada);
	}
	
	@GetMapping("/traer/{id}")
	public Educacion traerEducacion(@PathVariable Integer id) {
		return intEducacionService.findEducacion(id);
	}
	
	@PutMapping("/modificar/{id_educacion}/{id_ciudad}")
	public void modificarEducacion (@PathVariable Integer id_educacion, 
			                        @PathVariable Long id_ciudad, 
			                        @RequestBody Educacion educacionParaModificar) {
		
		Educacion educacionModificada = intEducacionService.findEducacion(id_educacion);
				
		educacionModificada.setNombreInstitucion(educacionParaModificar.getNombreInstitucion());
		educacionModificada.setUrlInstitucion(educacionParaModificar.getUrlInstitucion());		
		educacionModificada.setEstudioCursado(educacionParaModificar.getEstudioCursado());
		educacionModificada.setAnioInicio(educacionParaModificar.getAnioInicio());
		educacionModificada.setAnioFin(educacionParaModificar.getAnioFin());
		educacionModificada.setDescripcionCurso(educacionParaModificar.getDescripcionCurso());
		educacionModificada.setSeTerminoCurso(educacionParaModificar.getSeTerminoCurso());
		educacionModificada.setCampoExtraTexto(educacionParaModificar.getCampoExtraTexto());
		educacionModificada.setCampoExtraNumber(educacionParaModificar.getCampoExtraNumber());
		educacionModificada.setCiudad(intCiudadService.findCiudad(id_ciudad));
		
		intEducacionService.saveEducacion(educacionModificada);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarEducacion(@PathVariable Integer id) {
		intEducacionService.deleteEducacion(id);
	}
		
}
