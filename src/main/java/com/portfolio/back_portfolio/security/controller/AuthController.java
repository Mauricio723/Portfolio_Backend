package com.portfolio.back_portfolio.security.controller;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.back_portfolio.security.dto.JwtDto;
import com.portfolio.back_portfolio.security.dto.LoginUsuario;
import com.portfolio.back_portfolio.security.dto.NuevoUsuario;
import com.portfolio.back_portfolio.security.entity.Rol;
import com.portfolio.back_portfolio.security.entity.Usuario;
import com.portfolio.back_portfolio.security.enums.RolNombre;
import com.portfolio.back_portfolio.security.jwt.JwtProvider;
import com.portfolio.back_portfolio.security.service.RolService;
import com.portfolio.back_portfolio.security.service.UsuarioService;
import com.portfolio.back_portfolio.security.utilidades.Mensaje;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    /* El siguiente endpoint espera y JSON y lo convierte a tipo clase NuevoUsuario */
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, 
    		                       BindingResult bindingResult) {
    	
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("Campos mal ingresados o email inválido"), 
            		                    HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
        	
            return new ResponseEntity<>(new Mensaje("Ese nombre de usuario ya existe"), 
            		                    HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
        	
            return new ResponseEntity<>(new Mensaje("Esa dirección de email ya existe"), 
            		                                HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), 
        		                      nuevoUsuario.getNombreUsuario(), 
        		                      nuevoUsuario.getEmail(), 
        		                      passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) {
        	
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        
        usuario.setRoles(roles);
        
        usuarioService.save(usuario);

        return new ResponseEntity<>(new Mensaje("Usuario creado exitosamente"), 
        		                    HttpStatus.CREATED);

    }

    @PostMapping ("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, 
    		                            BindingResult bindingResult) {
        
    	if (bindingResult.hasErrors()) {
   
            //return new ResponseEntity(new Mensaje("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginUsuario.getNombreUsuario(), 
        				loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.GenerateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), 
        		                   userDetails.getAuthorities());

        return new ResponseEntity<>(jwtDto, HttpStatus.OK);

    }
}
