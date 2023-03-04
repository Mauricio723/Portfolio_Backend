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

import com.portfolio.back_portfolio.modelo.Trabajo;
import com.portfolio.back_portfolio.servicio.ICiudadService;
import com.portfolio.back_portfolio.servicio.IPersonaService;
import com.portfolio.back_portfolio.servicio.ITrabajoService;

@RestController
@RequestMapping("/myapi/trabajos")
public class TrabajoController {

	@Autowired
	private ITrabajoService intTrabajoService;
	
	@Autowired
	private IPersonaService intPersonaService;
	
	@Autowired
	private ICiudadService intCiudadService;
	
	@GetMapping("/traer_todos")
	public List<Trabajo> getTrabajos() {
		return intTrabajoService.getTrabajos();
	}
	
	@PostMapping("/crear/{id_persona}/{id_ciudad}")
	public void crearTrabajo(@RequestBody Trabajo trabajoCreado, 
			                 @PathVariable Long id_persona, 
			                 @PathVariable Long id_ciudad) {
		
		trabajoCreado.setPersona(intPersonaService.findPersona(id_persona));
		trabajoCreado.setCiudad(intCiudadService.findCiudad(id_ciudad));
		intTrabajoService.saveTrabajo(trabajoCreado);
	}
		
	@GetMapping("/traer/{id}")
	public Trabajo traerTrabajo(@PathVariable Integer id) {
		return intTrabajoService.findTrabajo(id);
	}
	
	@PutMapping("/modificar/{id_trabajo}/{id_ciudad}")
	public void modificarTrabajo(@PathVariable Integer id_trabajo, @PathVariable Long id_ciudad, @RequestBody Trabajo trabajoParaModificar) {
		Trabajo trabajoModificado = intTrabajoService.findTrabajo(id_trabajo);
		trabajoModificado.setNombreEmpresa(trabajoParaModificar.getNombreEmpresa());
		trabajoModificado.setPuestoLaboral(trabajoParaModificar.getPuestoLaboral());
		trabajoModificado.setAnioInicio(trabajoParaModificar.getAnioInicio());
		trabajoModificado.setAnioFin(trabajoParaModificar.getAnioFin());		
		trabajoModificado.setDescripcion(trabajoParaModificar.getDescripcion());
		trabajoModificado.setCiudad(intCiudadService.findCiudad(id_ciudad));
		
		intTrabajoService.saveTrabajo(trabajoModificado);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarTrabajo (@PathVariable Integer id) {
		intTrabajoService.deleteTrabajo(id);
	}
	
}
