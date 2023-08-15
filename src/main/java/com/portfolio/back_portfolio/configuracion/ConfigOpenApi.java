package com.portfolio.back_portfolio.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigOpenApi {
	
	@Bean
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI().components(new Components())
				       .info(new Info().title("Portfolio Web")
				       .description("Backend de Portfolio Web") 
				       .contact(new Contact().name("Salvador Mauricio Vilches Jerez")
				                              .email("salvadorvilches1972@gmail.com"))
				       .version("1.0.0"));
	}
			

}
