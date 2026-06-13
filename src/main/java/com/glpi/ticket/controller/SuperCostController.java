package com.glpi.ticket.controller;

import com.glpi.ticket.dto.SuperCostRequest;
import com.glpi.ticket.model.SuperCost;
import com.glpi.ticket.repository.SuperCostRepository;
import com.glpi.ticket.service.SuperCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/super-cost")
@CrossOrigin(origins = "*")
public class SuperCostController {

    private final SuperCostService superCostService;
    private SuperCostRepository superCostRepository;

    public SuperCostController(SuperCostService superCostService,
                            SuperCostRepository superCostRepository) {
        this.superCostService = superCostService;
        this.superCostRepository = superCostRepository;
    }
    
    @PostMapping
    public ResponseEntity<?> saveSuperCost(@RequestBody SuperCostRequest request) {
        try {
            SuperCost superCost = new SuperCost(request.getIdTicket(), request.getSuperCost());
            SuperCost saved = superCostRepository.save(superCost);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'enregistrement du superCost : " + e.getMessage());
        }
    }
    
    @GetMapping("/ticket/{idTicket}")
    public ResponseEntity<?> getSuperCostsByTicket(@PathVariable Long idTicket) {
        return ResponseEntity.ok(superCostRepository.findByIdTicket(idTicket));
    }


    // @GetMapping("/{idTicket}")
    // public ResponseEntity<?> getLastSuperCost(@PathVariable Long idTicket) {
    //     return ResponseEntity.ok(superCostRepository.getLastIdByticketId(idTicket));
    // }

    @GetMapping("/{idTicket}")
    public ResponseEntity<?> getLastSuperCost(@PathVariable Long idTicket) {
        return ResponseEntity.ok(superCostService.getLastSuperCostByTicketId(idTicket));
    }

}