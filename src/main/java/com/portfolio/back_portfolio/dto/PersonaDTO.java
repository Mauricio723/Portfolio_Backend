package com.portfolio.back_portfolio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.portfolio.back_portfolio.modelo.Aptitud;
import com.portfolio.back_portfolio.modelo.Ciudad;
import com.portfolio.back_portfolio.modelo.Educacion;
import com.portfolio.back_portfolio.modelo.Proyecto;
import com.portfolio.back_portfolio.modelo.Trabajo;

public class PersonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private Long id;	
	private String nombre;	
	private String apellido;	
	private String ocupacion;	
	private Date fechaNacimiento;	
	private String documento;	
	private String email;	
	private String acercaDeMi;	
	private String urlFoto;	
	private String urlBanner;	
	private Ciudad ciudad;	
	private List<Educacion> listaEducacion;	
	private List<Trabajo> listaTrabajo;	
	private List<Proyecto> listaProyecto;	
	private List<Aptitud> listaAptitud;	
	
	public PersonaDTO () {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcercaDeMi() {
		return acercaDeMi;
	}

	public void setAcercaDeMi(String acercaDeMi) {
		this.acercaDeMi = acercaDeMi;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getUrlBanner() {
		return urlBanner;
	}

	public void setUrlBanner(String urlBanner) {
		this.urlBanner = urlBanner;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Educacion> getListaEducacion() {
		return listaEducacion;
	}

	public void setListaEducacion(List<Educacion> listaEducacion) {
		this.listaEducacion = listaEducacion;
	}

	public List<Trabajo> getListaTrabajo() {
		return listaTrabajo;
	}

	public void setListaTrabajo(List<Trabajo> listaTrabajo) {
		this.listaTrabajo = listaTrabajo;
	}

	public List<Proyecto> getListaProyecto() {
		return listaProyecto;
	}

	public void setListaProyecto(List<Proyecto> listaProyecto) {
		this.listaProyecto = listaProyecto;
	}

	public List<Aptitud> getListaAptitud() {
		return listaAptitud;
	}

	public void setListaAptitud(List<Aptitud> listaAptitud) {
		this.listaAptitud = listaAptitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
