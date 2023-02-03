package com.portfolio.back_portfolio.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NuevoUsuario {
	
	@NotBlank
    private String nombre;
	@NotBlank
    private String nombreUsuario;
	@NotBlank
    private String email;
	@NotBlank
    private String password;
	
	/* Por defecto se crea un usuario normal; si queremos
	 * un usuario Admin, hay que especificarlo en el campo roles */
	
    private Set<String> roles = new HashSet<>();
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
