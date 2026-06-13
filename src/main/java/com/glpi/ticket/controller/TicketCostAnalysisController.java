package com.glpi.ticket.controller;

import com.glpi.ticket.model.SuperCost;
import com.glpi.ticket.repository.SuperCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/ticket-cost-analysis")
@CrossOrigin(origins = "*")
public class TicketCostAnalysisController {
    
    @Autowired
    private SuperCostRepository superCostRepository;
    
    @GetMapping("/supercosts")
    public List<SuperCost> getAllSuperCosts() {
        return superCostRepository.findAll();
    }
    
    @GetMapping("/supercosts/ticket/{ticketId}")
    public List<SuperCost> getSuperCostsByTicket(@PathVariable Long ticketId) {
        return superCostRepository.findByIdTicket(ticketId);
    }
}