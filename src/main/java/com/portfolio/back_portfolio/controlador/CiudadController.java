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

import com.portfolio.back_portfolio.modelo.Ciudad;
import com.portfolio.back_portfolio.servicio.ICiudadService;

@RestController
@RequestMapping("myapi/ciudades")
public class CiudadController {

	@Autowired
	private ICiudadService inciudadService;
	
	@GetMapping("/traer_todas")
	public List<Ciudad> getCiudad() {
		return inciudadService.getCiudades();
	}
	
	@PostMapping("/crear")
	public void crearCiudad(@RequestBody Ciudad ciudadCreada) {
		inciudadService.saveCiudad(ciudadCreada);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminarCiudad(@PathVariable Long id) {
		inciudadService.deleteCiudad(id);
	}
	
	@PutMapping("/modificar/{id}")
	public void modificarCiudad (@PathVariable Long id, @RequestBody Ciudad ciudadParaModificar) {
		Ciudad ciudadModificada = inciudadService.findCiudad(id);
		ciudadModificada.setNombre(ciudadParaModificar.getNombre());
		ciudadModificada.setProvincia(ciudadParaModificar.getProvincia());
		ciudadModificada.setPais(ciudadParaModificar.getPais());
		
		inciudadService.saveCiudad(ciudadModificada);		
	}
}
