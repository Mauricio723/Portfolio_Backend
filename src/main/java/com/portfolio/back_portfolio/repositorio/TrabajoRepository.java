package com.portfolio.back_portfolio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.back_portfolio.modelo.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
		
}
