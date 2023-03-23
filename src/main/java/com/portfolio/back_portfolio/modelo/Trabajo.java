package com.portfolio.back_portfolio.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trabajos")
public class Trabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;

	@Column(length=50)
	private String nombreEmpresa;
	@Column(length=50)
	private String puestoLaboral;
	@Column(length=5)
	private int anioInicio;
	@Column(length=5)
	private int anioFin;
	@Column(length=200)
	private String descripcion;
	@Column(length=100)
	private String campoExtraTexto;
	@Column(length=20)
	private int campoExtraNumber;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ciudad_id")
	private Ciudad ciudad;

	@ManyToOne()
	@JoinColumn(name = "persona_id")
	@JsonIgnore
	private Persona persona;

	public Trabajo() {
		super();
	}	

	public Trabajo(Integer id, String nombreEmpresa, String puestoLaboral, int anioInicio, int anioFin,
			String descripcion,String campoExtraTexto, int campoExtraNumber, Ciudad ciudad, Persona persona) {
		super();
		this.id = id;
		this.nombreEmpresa = nombreEmpresa;
		this.puestoLaboral = puestoLaboral;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
		this.descripcion = descripcion;
		this.campoExtraTexto = campoExtraTexto;
		this.campoExtraNumber = campoExtraNumber;
		this.ciudad = ciudad;
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getPuestoLaboral() {
		return puestoLaboral;
	}

	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}

	public int getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	public int getAnioFin() {
		return anioFin;
	}

	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	public String getCampoExtraTexto() {
		return campoExtraTexto;
	}

	public void setCampoExtraTexto(String campoExtraTexto) {
		this.campoExtraTexto = campoExtraTexto;
	}

	public int getCampoExtraNumber() {
		return campoExtraNumber;
	}

	public void setCampoExtraNumber(int campoExtraNumber) {
		this.campoExtraNumber = campoExtraNumber;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
