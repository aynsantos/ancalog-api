package com.ancalaghon.ancalog.service;

import com.ancalaghon.ancalog.exception.EntityNotFoundException;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery search(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega na encontrada"));
    }


}
