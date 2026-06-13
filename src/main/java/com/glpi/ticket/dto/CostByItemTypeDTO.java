package com.glpi.ticket.dto;

public class CostByItemTypeDTO {
    private String itemType;
    private Double totalGlpiCost;
    private Double totalSuperCost;
    private Double total;
    
    // Constructeur par défaut
    public CostByItemTypeDTO() {}
    
    // Constructeur avec paramètres
    public CostByItemTypeDTO(String itemType, Double totalGlpiCost, Double totalSuperCost) {
        this.itemType = itemType;
        this.totalGlpiCost = totalGlpiCost;
        this.totalSuperCost = totalSuperCost;
        this.total = totalGlpiCost + totalSuperCost;
    }
    
    // Getters et Setters
    public String getItemType() {
        return itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    public Double getTotalGlpiCost() {
        return totalGlpiCost;
    }
    
    public void setTotalGlpiCost(Double totalGlpiCost) {
        this.totalGlpiCost = totalGlpiCost;
    }
    
    public Double getTotalSuperCost() {
        return totalSuperCost;
    }
    
    public void setTotalSuperCost(Double totalSuperCost) {
        this.totalSuperCost = totalSuperCost;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
}