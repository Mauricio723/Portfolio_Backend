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

import com.portfolio.back_portfolio.modelo.Aptitud;
import com.portfolio.back_portfolio.servicio.IAptitudService;
import com.portfolio.back_portfolio.servicio.IPersonaService;

@RestController
@RequestMapping("/myapi/aptitudes")
public class AptitudController {

	@Autowired
	private IAptitudService intAptitudService;
	
	@Autowired
	private IPersonaService intPersonaService;
	
	@GetMapping("/traer_todas")
	public List<Aptitud> traerAptitudes() {
		List<Aptitud> listaAptitudes = intAptitudService.getAptitudes();
		return listaAptitudes;
	}
	
	@PostMapping("/crear/{id_persona}")
	public void crearAptitud(@RequestBody Aptitud aptitudCreada, @PathVariable Long id_persona) {
		aptitudCreada.setPersona(intPersonaService.findPersona(id_persona));
		intAptitudService.saveAptitud(aptitudCreada);
	}
	
	@GetMapping("/traer/{id}")
	public Aptitud traerAptitud(@PathVariable Integer id) {
		return intAptitudService.findAptitud(id);
	}
	
	@PutMapping("/modificar/{id}")
	public void modificarAptitud (@PathVariable Integer id, @RequestBody Aptitud aptitudParaModificar) {
		Aptitud aptitudModificada = intAptitudService.findAptitud(id);
		aptitudModificada.setNombre(aptitudParaModificar.getNombre());
		aptitudModificada.setDescripcion(aptitudParaModificar.getDescripcion());
		aptitudModificada.setPorcentaje(aptitudParaModificar.getPorcentaje());
		
		intAptitudService.saveAptitud(aptitudModificada);
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminarAptitud(@PathVariable Integer id) {
		intAptitudService.deleteAptitud(id);
	}
		
}
