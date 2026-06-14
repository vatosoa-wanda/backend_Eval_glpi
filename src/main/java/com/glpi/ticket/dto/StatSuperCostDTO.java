package com.glpi.ticket.dto; // ou votre package approprié

import java.math.BigDecimal;

public interface StatSuperCostDTO {
    String getItemType();
    BigDecimal getTotalCost();
    BigDecimal getTotalGlpiCost();
    BigDecimal getTotalReopenCost();
}