/*package com.portfolio.back_portfolio.security.utilidades;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;*/

/*@Configuration
public class ConfiguracionCors {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registroCors) {
				
				registroCors.addMapping("/auth/**")
				            .allowedOrigins("http://localhost:4200")
				            .allowedMethods("*")
				            .exposedHeaders("*");
				
				registroCors.addMapping("/myapi/**")    // aceptamos las rutas que comiencen con myapi
				            .allowedOrigins("http://localhost:4200")
				            .allowedMethods("*");                    // se aceptan todos los métodos
			}
			
		};
	}
}*/
