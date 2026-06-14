package com.glpi.ticket.repository;

import com.glpi.ticket.model.SuperCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.glpi.ticket.dto.StatSuperCostDTO;

@Repository
public interface SuperCostRepository extends JpaRepository<SuperCost, Long> {
    List<SuperCost> findByIdTicket(Long idTicket);

    List<SuperCost> findByItemType(String itemType);

    // @Query("SELECT s.itemType as itemType, SUM(s.cost) as totalCost, SUM(s.glpiCost) as totalGlpiCost " +
    //        "FROM SuperCost s " +
    //        "GROUP BY s.itemType")
    // List<StatSuperCostDTO> getSumOfCostsGroupedByItemType();

    @Query("SELECT s.itemType as itemType, " +
           "SUM(CASE WHEN s.typeCout = 'Glpi' THEN s.cost ELSE 0 END) as totalGlpiCost, " +
           "SUM(CASE WHEN s.typeCout = 'SuperCost' THEN s.cost ELSE 0 END) as totalCost " +
           "FROM SuperCost s " +
           "GROUP BY s.itemType")
    List<StatSuperCostDTO> getSumOfCostsGroupedByItemType();

}