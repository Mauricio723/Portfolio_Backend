/*package com.portfolio.back_portfolio.security.utilidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfolio.back_portfolio.security.entity.Rol;
import com.portfolio.back_portfolio.security.enums.RolNombre;
import com.portfolio.back_portfolio.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RolService rol_service;
	
	@Override
	public void run(String... args) throws Exception {
		
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		
		rol_service.save(rolAdmin);
		rol_service.save(rolUser);
		
	}
	
}
*/