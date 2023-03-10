package com.portfolio.back_portfolio.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;

import com.portfolio.back_portfolio.security.enums.RolNombre;
import com.sun.istack.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    
    /* Enumtype indica que se va a hacer un Enum del tipo String */
    
    @NotNull
    @Enumerated(EnumType.STRING) 
    private RolNombre rolNombre;
        
    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }    
    
}
