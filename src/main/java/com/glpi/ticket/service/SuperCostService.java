package com.glpi.ticket.service;:

import com.glpi.ticket.repository.SuperCostRepository;
import org.springframework.stereotype.Service;
import com.glpi.ticket.model.SuperCost;
import java.util.List;

@Service
public class SuperCostService {

    private final SuperCostRepository superCostRepository;

    public SuperCostService(SuperCostRepository superCostRepository) {
        this.superCostRepository = superCostRepository;
    }


    public SuperCost getLastSuperCostByTicketId(Long idTicket) {
        List<SuperCost> list = superCostRepository.findByIdTicket(idTicket);
        SuperCost last = list.get(list.size() - 1);
        return last;
    }

}
