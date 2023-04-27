package com.portfolio.back_portfolio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Integer id;
	
	@Column(length=100)
	private String nombre;
	@Column(length=200)
	private String descripcion;
	@Column(length=100)
	private String fechaPublicacion;
	
	@Column(name="persona_id",length=4)
	private Long persona_id;	
	
	public Proyecto() {
		super();
	}

	public Proyecto(Integer id, String nombre, String descripcion, String fechaPublicacion, Long persona_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaPublicacion = fechaPublicacion;
		this.persona_id = persona_id;
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
	
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Long getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Long persona_id) {
		this.persona_id = persona_id;
	}
	
}
