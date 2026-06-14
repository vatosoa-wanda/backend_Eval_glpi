package com.glpi.ticket.repository;

import com.glpi.ticket.model.SuperCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.glpi.ticket.dto.StatSuperCostDTO;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
           "SUM(CASE WHEN s.typeCout = 'SuperCost' THEN s.cost ELSE 0 END) as totalCost, " +
           "SUM(CASE WHEN s.typeCout = 'Reouverture' THEN s.cost ELSE 0 END) as totalReopenCost " +
           "FROM SuperCost s " +
           "GROUP BY s.itemType")
    List<StatSuperCostDTO> getSumOfCostsGroupedByItemType();

    Optional<SuperCost> findFirstByIdTicketAndTypeCoutOrderByIdCostDesc(Long idTicket, String typeCout);

    // 2. Supprimer TOUTES les lignes d'un lot via son groupTimestamp
    @Modifying
    @Transactional
    @Query("DELETE FROM SuperCost s WHERE s.idTicket = :idTicket AND s.groupTimestamp = :groupTimestamp AND s.typeCout = 'SuperCost'")
    void deleteByIdTicketAndGroupTimestamp(@Param("idTicket") Long idTicket, @Param("groupTimestamp") Long groupTimestamp);

    @Query("SELECT s FROM SuperCost s WHERE s.idTicket = :idTicket AND s.idItem = :idItem AND s.typeCout = 'Glpi'")
    Optional<SuperCost> findGlpiCostByTicketAndItem(@Param("idTicket") Long idTicket, @Param("idItem") Long idItem);

}