package com.glpi.ticket.dto;

import java.math.BigDecimal;

public class SuperCostRequest {
    private Long idTicket;
    private BigDecimal superCost;
    
    // Getters et Setters
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