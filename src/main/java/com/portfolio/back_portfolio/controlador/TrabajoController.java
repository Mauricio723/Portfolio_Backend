package com.portfolio.back_portfolio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.modelo.Trabajo;
import com.portfolio.back_portfolio.servicio.ITrabajoService;

@RestController
public class TrabajoController {

	@Autowired
	private ITrabajoService interfTrabajoService;
	
	@GetMapping("/trabajos/traer_todos")
	public List<Trabajo> getTrabajos() {
		return interfTrabajoService.getTrabajos();
	}
	
	@PostMapping("/trabajos/crear")
	public void crearTrabajo(@RequestBody Trabajo trabajoCreado) {
		interfTrabajoService.saveTrabajo(trabajoCreado);
	}
		
}
