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
@Table(name="educacion")
public class Educacion {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Integer id;
	
	@Column(length=60)
	private String nombreInstitucion;	
	@Column(length=60)
	private String estudioCursado;
	@Column(length=5)
	private int anioInicio;
	@Column(length=5)
	private int anioFin;
	@Column(length=200)
	private String descripcionCurso;
	@Column(length=2)
	private int seTerminoCurso;
		 
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
	
	@ManyToOne()
	@JoinColumn(name="persona_id")
	@JsonIgnore
	private Persona persona;
	
	public Educacion() {
		super();
	}

	public Educacion(Integer id, String nombreInstitucion, String estudioCursado, int anioInicio, int anioFin,
			String descripcionCurso, int seTerminoCurso, Ciudad ciudad, Persona persona) {
		super();
		this.id = id;
		this.nombreInstitucion = nombreInstitucion;
		this.estudioCursado = estudioCursado;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
		this.descripcionCurso = descripcionCurso;
		this.seTerminoCurso = seTerminoCurso;
		this.ciudad = ciudad;
		this.persona = persona;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstudioCursado() {
		return estudioCursado;
	}

	public void setEstudioCursado(String estudioCursado) {
		this.estudioCursado = estudioCursado;
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

	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	public int getSeTerminoCurso() {
		return seTerminoCurso;
	}

	public void setSeTerminoCurso(int seTerminoCurso) {
		this.seTerminoCurso = seTerminoCurso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}		
	
}
