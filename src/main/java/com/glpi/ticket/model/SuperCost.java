package com.glpi.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class SuperCost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCost;
    
    private Long idTicket;
    
    private BigDecimal superCost;
    
    // Constructeur par défaut
    public SuperCost() {}
    
    // Constructeur avec paramètres
    public SuperCost(Long idTicket, BigDecimal superCost) {
        this.idTicket = idTicket;
        this.superCost = superCost;
    }
    
    // Getters et Setters
    public Long getIdCost() {
        return idCost;
    }
    
    public void setIdCost(Long idCost) {
        this.idCost = idCost;
    }
    
    public Long getIdTicket() {
        return idTicket;
    }
    
    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }
    
    public BigDecimal getSuperCost() {
        return superCost;
    }
    
    public void setSuperCost(BigDecimal superCost) {
        this.superCost = superCost;
    }
}