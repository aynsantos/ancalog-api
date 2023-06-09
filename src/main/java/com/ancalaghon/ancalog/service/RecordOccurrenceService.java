package com.ancalaghon.ancalog.service;


import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {

    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Occurrence record(Long deliveryId, String description) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return delivery.addOccurrence(description);
    }
}
