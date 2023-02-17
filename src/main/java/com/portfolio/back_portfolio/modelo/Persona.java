package com.portfolio.back_portfolio.modelo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String tituloPrincipal;
	
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
		
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Educacion> listaEducacion;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabajo> listaTrabajos;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyecto> listaProyectos;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aptitud> listaAptitudes;
		
	public Persona() {
		super();
	}

	
	public Persona(Long id, String nombre, String apellido, String ocupacion, String tituloPrincipal,
			String fecha_nacimiento, String documento, String email, String acerca_de, String urlFoto, String urlBanner,
			Ciudad ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ocupacion = ocupacion;
		this.tituloPrincipal = tituloPrincipal;
		this.fecha_nacimiento = fecha_nacimiento;
		this.documento = documento;
		this.email = email;
		this.acerca_de = acerca_de;
		this.urlFoto = urlFoto;
		this.urlBanner = urlBanner;
		this.ciudad = ciudad;
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

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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

	public String getAcerca_de() {
		return acerca_de;
	}

	public void setAcerca_de(String acerca_de) {
		this.acerca_de = acerca_de;
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


	public String getTituloPrincipal() {
		return tituloPrincipal;
	}


	public void setTituloPrincipal(String tituloPrincipal) {
		this.tituloPrincipal = tituloPrincipal;
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


	public List<Trabajo> getListaTrabajos() {
		return listaTrabajos;
	}


	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}


	public List<Aptitud> getListaAptitudes() {
		return listaAptitudes;
	}	
	
	
	
}
