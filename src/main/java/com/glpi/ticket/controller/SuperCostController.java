package com.glpi.ticket.controller;

import com.glpi.ticket.dto.SuperCostRequest;
import com.glpi.ticket.model.SuperCost;
import com.glpi.ticket.repository.SuperCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/super-cost")
@CrossOrigin(origins = "*")
public class SuperCostController {

    private SuperCostRepository superCostRepository;

    public SuperCostController(SuperCostRepository superCostRepository) {
        this.superCostRepository = superCostRepository;
    }
    
    @PostMapping
    public ResponseEntity<?> saveCost(@RequestBody SuperCostRequest request) {
        try {
            SuperCost Cost = new SuperCost(request.getIdTicket(), request.getTypeCout(), request.getCost(), request.getIdItem(), request.getItemType(), request.getGroupTimestamp());
            SuperCost saved = superCostRepository.save(Cost);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'enregistrement du superCost : " + e.getMessage());
        }
    }

    @GetMapping("/stats-by-type")
    public ResponseEntity<?> getSumOfCostsGroupedByItemType() {
        try {
            return ResponseEntity.ok(superCostRepository.getSumOfCostsGroupedByItemType());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération des statistiques : " + e.getMessage());
        }
    }

    // @GetMapping("/{itemType}")
    // public ResponseEntity<?> getSuperCostByItemType(@PathVariable String itemType) {
    //     return ResponseEntity.ok(superCostRepository.findByItemType(itemType));
    // }

    
    @GetMapping("/ticket/{idTicket}")
    public ResponseEntity<?> getSuperCostsByTicket(@PathVariable Long idTicket) {
        return ResponseEntity.ok(superCostRepository.findByIdTicket(idTicket));
    }

    @DeleteMapping("/ticket/{idTicket}/latest-batch")
    public ResponseEntity<?> deleteLatestCostBatch(@PathVariable Long idTicket) {
        try {
            Optional<SuperCost> latest = superCostRepository.findFirstByIdTicketAndTypeCoutOrderByIdCostDesc(idTicket, "SuperCost");
            
            if (latest.isPresent() && latest.get().getGroupTimestamp() != null) {
                Long lastTimestamp = latest.get().getGroupTimestamp();
                superCostRepository.deleteByIdTicketAndGroupTimestamp(idTicket, lastTimestamp);
                return ResponseEntity.ok("Le dernier lot de coûts (Timestamp: " + lastTimestamp + ") a été supprimé.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun coût avec un groupe valide n'a été trouvé pour le ticket #" + idTicket);
                    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression du lot de coûts : " + e.getMessage());
        }
    }

    // @GetMapping("/ticket/{idTicket}/last-superCost")
    // public ResponseEntity<?> getLastSuperCostsByTicket(@PathVariable Long idTicket) {
    //     return ResponseEntity.ok(superCostRepository.findFirstByIdTicketAndTypeCoutOrderByIdCostDesc(idTicket,"SuperCost"));
    // }

    @GetMapping("/last-supercost/ticket/{idTicket}")
    public ResponseEntity<?> getLastSuperCostsByTicket(@PathVariable Long idTicket) {
        Optional<SuperCost> latest = superCostRepository.findFirstByIdTicketAndTypeCoutOrderByIdCostDesc(idTicket, "SuperCost");
        
        if (latest.isPresent()) {
            // Retourne l'unique ligne SuperCost trouvée
            return ResponseEntity.ok(latest.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun SuperCost trouvé pour le ticket #" + idTicket);
        }
    }

    @GetMapping("/ticket/{idTicket}/item/{idItem}/glpi-cost")
    public ResponseEntity<?> getGlpiCostByTicketAndItem(@PathVariable Long idTicket, @PathVariable Long idItem) {
        Optional<SuperCost> optSuperCost = superCostRepository.findGlpiCostByTicketAndItem(idTicket, idItem);
        
        if (optSuperCost.isPresent()) {
            // On extrait l'objet et on renvoie directement son coût (BigDecimal)
            return ResponseEntity.ok(optSuperCost.get().getCost());
        } else {
            // En cas d'absence, on renvoie le message d'erreur (String)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aucun coût GLPI trouvé pour le ticket #" + idTicket + " et l'item #" + idItem);
        }
    }


}