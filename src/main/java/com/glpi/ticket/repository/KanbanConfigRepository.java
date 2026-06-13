package com.glpi.ticket.repository;

import com.glpi.ticket.model.KanbanConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KanbanConfigRepository extends JpaRepository<KanbanConfig, Integer> {}