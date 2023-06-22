package com.portfolio.back_portfolio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import io.jsonwebtoken.lang.Arrays;

@SpringBootApplication
public class BackPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackPortfolioApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				        .allowedOrigins("http://localhost:4200", "https://portfoliomv72.web.app")				        
				        .allowedMethods("*")
				        //.allowCredentials(true)
				        .allowedHeaders("*");				    	        
			}
		};
	}
	
}
