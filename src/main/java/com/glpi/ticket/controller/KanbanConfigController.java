package com.glpi.ticket.controller;

import com.glpi.ticket.model.KanbanConfig;
import com.glpi.ticket.repository.KanbanConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/kanban-config")
@CrossOrigin(origins = "*")
public class KanbanConfigController {

    @Autowired
    private KanbanConfigRepository repository;

    // Récupère toutes les lignes (les couleurs de tous les statuts configurés)
    @GetMapping
    public List<KanbanConfig> getAllConfigs() {
        return repository.findAll();
    }

    // Sauvegarde ou met à jour la liste complète des couleurs envoyée par Vue.js
    @PostMapping
    public List<KanbanConfig> saveAllConfigs(@RequestBody List<KanbanConfig> configs) {
        return repository.saveAll(configs);
    }
}