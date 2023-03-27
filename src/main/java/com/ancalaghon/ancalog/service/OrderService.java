package com.ancalaghon.ancalog.service;


import com.ancalaghon.ancalog.model.Client;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.model.DeliveryStatus;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class OrderService {

    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    @Transactional
    public Delivery requestDelivery (Delivery delivery) {
        Client client = clientService.findCustomer(delivery.getClient().getId());


        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderTimeStamp(OffsetDateTime.now());

        return deliveryRepository.save(delivery);

    }
}

