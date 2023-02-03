package com.portfolio.back_portfolio.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.security.entity.Usuario;
import com.portfolio.back_portfolio.security.entity.UsuarioPrincipal;

/* Esta clase convierte la clase usuario en un UsuarioPrincipal */

@Service
@Transactional
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		 
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();	  
		
		return UsuarioPrincipal.build(usuario);
	}  

}
