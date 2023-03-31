package com.ancalaghon.ancalog.service;



import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizeDeliveryService {

    private SearchDeliveryService searchDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void finalizeDelivery(Long deliveryId) {

        Delivery delivery = searchDeliveryService.search(deliveryId);

        delivery.finalizeDelivery();

        deliveryRepository.save(delivery);

    }
}
