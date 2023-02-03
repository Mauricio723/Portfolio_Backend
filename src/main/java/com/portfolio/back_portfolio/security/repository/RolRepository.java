package com.portfolio.back_portfolio.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.back_portfolio.security.entity.Rol;
import com.portfolio.back_portfolio.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol>findByRolNombre (RolNombre rolNombre);
                
}
