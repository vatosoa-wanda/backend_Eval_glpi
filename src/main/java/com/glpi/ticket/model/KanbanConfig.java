package com.glpi.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KanbanConfig {
    @Id
    private Integer statusId; // 1, 2, 3, 4, 5, 6...
    private String color;
    private String statusMlg;

    // Constructeur par défaut obligatoire pour JPA
    public KanbanConfig() {}

    public KanbanConfig(Integer statusId, String color, String statusMlg) {
        this.statusId = statusId;
        this.color = color;
        this.statusMlg = statusMlg;
    }

    // Getters et Setters
    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getStatusMlg() { return statusMlg; }
    public void setStatusMlg(String statusMlg) { this.statusMlg = statusMlg; }
}