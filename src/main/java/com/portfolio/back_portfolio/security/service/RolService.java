package com.portfolio.back_portfolio.security.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.back_portfolio.security.entity.Rol;
import com.portfolio.back_portfolio.security.enums.RolNombre;
import com.portfolio.back_portfolio.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }

    // metodo para guardar cambios
    
    public void save(Rol rol) {    	
        rolRepository.save(rol);        
    }

}

