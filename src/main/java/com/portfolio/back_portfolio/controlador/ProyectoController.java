package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Proyecto;
import com.portfolio.back_portfolio.servicio.IProyectoService;

@RestController
public class ProyectoController {

	@Autowired
	private IProyectoService interfProyectoService;
	
	@GetMapping("/proyectos/traer_todos")
	public List<Proyecto> getProyectos() {
		return interfProyectoService.getProyectos();
	}
	
	@PostMapping("/proyectos/crear")
	public void crearProyecto(@RequestBody Proyecto proyectoCreado) {
		interfProyectoService.saveProyecto(proyectoCreado);
	}
	
}
