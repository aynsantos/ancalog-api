package com.ancalaghon.ancalog.service;


import com.ancalaghon.ancalog.exception.BusinessException;
import com.ancalaghon.ancalog.exception.EntityNotFoundException;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.model.Occurrence;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {

    private DeliveryRepository deliveryRepository;

    @Transactional
    public Occurrence record(Long deliveryId, String description) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));

        return delivery.addOccurrence(description);
    }
}
