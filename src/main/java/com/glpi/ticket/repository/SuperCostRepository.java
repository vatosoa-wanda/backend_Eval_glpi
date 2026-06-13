package com.glpi.ticket.repository;

import com.glpi.ticket.model.SuperCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SuperCostRepository extends JpaRepository<SuperCost, Long> {
    List<SuperCost> findByIdTicket(Long idTicket);

    SuperCost getLastByticketId(Long idTicket);
}