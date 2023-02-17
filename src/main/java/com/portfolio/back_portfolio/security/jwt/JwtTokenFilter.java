package com.portfolio.back_portfolio.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portfolio.back_portfolio.security.service.UserDetailsImpl;

/* Esta clase utiliza el JwtProvider para validar que el token sea válido
 * y permitir los accesos a los diferentes recursos. */
/* esta clase Se ejecuta por cada petición */

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    UserDetailsImpl userDetailsServiceImpl;

    /* El siguiente método se ejecuta cada vez que se le haga una petición al server */
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    		                       HttpServletResponse response, 
    		                       FilterChain filterChain) 
    		                       throws ServletException, IOException {
    	
        try {
            String token = getToken(request);
            
            if (token != null && jwtProvider.validateToken(token)) {
            	
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                
                UsernamePasswordAuthenticationToken auth = 
                		new UsernamePasswordAuthenticationToken(userDetails, null, 
                				userDetails.getAuthorities());
                
                SecurityContextHolder.getContext().setAuthentication(auth);
                
            }
            
        } catch (Exception e) {
            logger.error("Falló el método doFilterInternal");
        }
        
        filterChain.doFilter(request, response);
    }

    /* Obtenemos el token sin Bearer ni el espacio */
    
    private String getToken(HttpServletRequest request) {
    	
        String header = request.getHeader("Authorization");
        
        if (header != null && header.startsWith("Bearer")) {
        	
        	/* reemplazamos Bearer más el espacio por nada,
        	 * para retornar solo el token */
        	
            return header.replace("Bearer ", "");
            
        }
        return null;
    }
}
