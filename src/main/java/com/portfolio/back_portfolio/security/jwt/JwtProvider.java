package com.portfolio.back_portfolio.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.portfolio.back_portfolio.security.entity.UsuarioPrincipal;

/* Esta clase genera el token y valida que esté bien formado y no esté expirado.*/

@Component
public class JwtProvider {
	
	/* Se implementa un logger para ver cual método da error en caso de falla */
	
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    /* Los siguientes valores son los están en aplicattion.properties */
    
   @Value("${jwt.secret}")
    private String secret;
    
   @Value("${jwt.expiration}")
    private int expiration;

    public String GenerateToken(Authentication authentication) {
    	
        UsuarioPrincipal usuarioPrincipal = 
        		(UsuarioPrincipal)authentication.getPrincipal();
                 
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
        	.setIssuedAt(new Date())   /* fecha creación del token */
        	.setExpiration(new Date(new Date().getTime() + expiration * 1000))   /* fecha expiración */
        	.signWith(SignatureAlgorithm.HS512,	secret)       /* Firma del token */
        	.compact();
    }

    /* Obtenemos el nombre del usuario a partir del token (subject -> nombre del usuario) */
    
    public String getNombreUsuarioFromToken(String token) {
    	
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
        		   .getBody().getSubject();

    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("Token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacío");
        } catch (SignatureException e) {
            logger.error("Firma no válida");
        }
        return false;
    }
}
