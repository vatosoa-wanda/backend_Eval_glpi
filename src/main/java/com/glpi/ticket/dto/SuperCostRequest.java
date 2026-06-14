package com.glpi.ticket.dto;

import java.math.BigDecimal;

public class SuperCostRequest {

    private Long idTicket;
    private String typeCout;
    private BigDecimal cost;
    private Long idItem;
    private String itemType;
    private Long groupTimestamp;
    
    
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