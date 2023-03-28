package com.ancalaghon.ancalog.controller;

import com.ancalaghon.ancalog.dto.DeliveryDTO;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import com.ancalaghon.ancalog.service.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
@Api(tags = "Delivery Controller")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;
    private ModelMapper modelMapper;
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request (@Valid @RequestBody Delivery delivery) {
        return orderService.requestDelivery(delivery);
    }

    @GetMapping
    public List<Delivery> deliveryList() {
        return deliveryRepository.findAll();

    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDTO> findById (@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> {
                    DeliveryDTO deliveryDTO = modelMapper.map(delivery, DeliveryDTO.class);
                    return ResponseEntity.ok(deliveryDTO);
                }).orElse(ResponseEntity.notFound().build());
    }

}
