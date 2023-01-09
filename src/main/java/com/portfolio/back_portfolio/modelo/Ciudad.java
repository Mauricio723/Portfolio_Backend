package com.portfolio.back_portfolio.modelo;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ciudades")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Long id;
	
	private String nombre;
	private String provincia;
	private String pais;
	
	/*@OneToMany(mappedBy="ciudad")
	private List<Persona_02> listaPersonas;*/
	
	public Ciudad() {
		super();
	}

	public Ciudad(Long id, String nombre, String provincia, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.pais = pais;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
		
}
