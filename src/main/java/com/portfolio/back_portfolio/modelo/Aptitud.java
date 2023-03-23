package com.portfolio.back_portfolio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aptitudes")
public class Aptitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;

	@Column(length=60)
	private String nombre;
	@Column(length=200)
	private String descripcion;
	@Column(length=4)
	private int porcentaje;

	@ManyToOne()
	@JoinColumn(name = "persona_id")
	@JsonIgnore
	private Persona persona;

	public Aptitud() {
		super();
	}

	public Aptitud(Integer id, 
			       String nombre, 
			       String descripcion, 
			       int porcentaje, 
			       Persona persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentaje = porcentaje;
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
