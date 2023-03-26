package com.portfolio.back_portfolio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.back_portfolio.modelo.Educacion;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
	
}
