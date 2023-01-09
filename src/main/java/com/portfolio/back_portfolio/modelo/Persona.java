package com.portfolio.back_portfolio.modelo;

//import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="personas")
public class Persona {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Long id;
	
	@Column(length=50)
	private String nombre;
	@Column(length=50)
	private String apellido;
	@Column(length=50)
	private String ocupacion;
		
	@Column(length=50)
	private String fecha_nacimiento;
	
	@Column(length=10)
	private String documento;
    
	@Column(length=100)
	private String email;
	
	@Column(length=100)
	private String acerca_de;
	
	@Column(length=100)
	private String urlFoto;
	@Column(length=100)
	private String urlBanner;
		
	/*@ManyToOne
	@JoinColumn(name="ciudad_id")
	private Ciudad ciudad;*/

	/*@OneToMany(mappedBy="persona")
	private List<Educacion> listaEducacion;
	 
	@OneToMany(mappedBy="persona")
	private List<Trabajo> listaTrabajo;
	
	@OneToMany(mappedBy="persona")
	private List<Proyecto> listaProyecto;
	
	@OneToMany(mappedBy="persona")
	private List<Aptitud> listaAptitud;*/
	
	
	public Persona() {
		super();
	}
	
}
