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

import com.portfolio.back_portfolio.modelo.Proyecto;
import com.portfolio.back_portfolio.servicio.IPersonaService;
import com.portfolio.back_portfolio.servicio.IProyectoService;

@RestController
@RequestMapping("/myapi/proyectos")
public class ProyectoController {

	@Autowired
	private IProyectoService intProyectoService;
	
	@Autowired
	private IPersonaService intPersonaService;
	
	@GetMapping("/traer_todos")
	public List<Proyecto> getProyectos() {
		return intProyectoService.getProyectos();
	}
	
	@PostMapping("/crear/{id_persona}")
	public void crearProyecto(@RequestBody Proyecto proyectoCreado, @PathVariable Long id_persona) {
		proyectoCreado.setPersona(intPersonaService.findPersona(id_persona));
		intProyectoService.saveProyecto(proyectoCreado);
	}
	
	@GetMapping("traer/{id}")
	public Proyecto traerProyecto(@PathVariable Integer id) {
		return intProyectoService.findProyecto(id);
	}
	
	@PutMapping("/modificar/{id}")
	public void modificarProyecto(@PathVariable Integer id, @RequestBody Proyecto proyectoParaModificar) {
		Proyecto proyectoModificado = intProyectoService.findProyecto(id);
		proyectoModificado.setNombre(proyectoParaModificar.getNombre());
		proyectoModificado.setDescripcion(proyectoParaModificar.getDescripcion());
		
		intProyectoService.saveProyecto(proyectoModificado);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarProyecto(@PathVariable Integer id) {
		intProyectoService.deleteProyecto(id);
	}
		
}
