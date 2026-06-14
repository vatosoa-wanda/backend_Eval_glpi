package com.glpi.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
public class SuperCost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCost")
    private Long idCost;
    
    @Column(name = "id_Ticket")
    private Long idTicket;

    @Column(name = "type_cout")
    private String typeCout;
    
    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "id_Item")
    private Long idItem;

    @Column(name = "item_Type")
    private String itemType;

    @Column(name = "group_timestamp")
    private Long groupTimestamp;
    
    // ==========================================
    // Constructeurs
    // ==========================================
    
    // Constructeur par défaut (Obligatoire pour JPA/Hibernate)
    public SuperCost() {}
    
    // Constructeur avec paramètres
    public SuperCost(Long idTicket, String typeCout ,BigDecimal cost, Long idItem, String itemType, Long groupTimestamp) {
        this.idTicket = idTicket;
        this.typeCout = typeCout;
        this.cost = cost;
        this.idItem = idItem;
        this.itemType = itemType;
        this.groupTimestamp = groupTimestamp;
    }
    
    // ==========================================
    // Getters et Setters (Standards Java)
    // ==========================================
    
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

    public String getTypeCout() {
        return typeCout;
    }

    public void setTypeCout(String typeCout) {
        this.typeCout = typeCout;
    }
    
    public BigDecimal getCost() {
        return cost;
    }
    
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Long getGroupTimestamp() {
        return groupTimestamp;
    }

    public void setGroupTimestamp(Long groupTimestamp) {
        this.groupTimestamp = groupTimestamp;
    }
}