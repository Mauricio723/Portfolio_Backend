package com.portfolio.back_portfolio.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/* Esta clase se encarga de generar la seguridad; 
 * implementa los privilegios de cada usuario 
 * con UserDetails, que es una clase propia de Spring Security */

public class UsuarioPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;

    /* La siguiente variable nos da la autorización, 
     * se trata de una colección del tipo genérica que extiende
     * de GranthedAuthority de Spring Security */
    
    private Collection <? extends GrantedAuthority> authorities;
      
    public UsuarioPrincipal(String nombre, String nombreUsuario, 
    		                String email, String password, 
    		                Collection<? extends GrantedAuthority> authorities) {
        
    	this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    /* El siguiente método asigna los privilegios (autorización) */
    
    public static UsuarioPrincipal build (Usuario usuario){
    	
    	/* Convertimos la clase Rol a la clase GrantedAuthority */
    	
        List<GrantedAuthority> authorities = 
        		usuario.getRoles()
        		.stream()
        		.map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
        		.collect(Collectors.toList());
        
        return new UsuarioPrincipal(usuario.getNombre(), 
        		                    usuario.getNombreUsuario(), 
        		                    usuario.getEmail(), 
        		                    usuario.getPassword(), 
        		                    authorities);
        
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
