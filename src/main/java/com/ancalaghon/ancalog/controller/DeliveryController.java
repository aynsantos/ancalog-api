package com.ancalaghon.ancalog.controller;

import com.ancalaghon.ancalog.dto.DeliveryDTO;
import com.ancalaghon.ancalog.dto.input.DeliveryInputDTO;
import com.ancalaghon.ancalog.mapper.DeliveryMapper;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.repository.DeliveryRepository;
import com.ancalaghon.ancalog.service.FinalizeDeliveryService;
import com.ancalaghon.ancalog.service.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
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
    private DeliveryMapper deliveryMapper;
    private OrderService orderService;
    private FinalizeDeliveryService finalizeDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO request (@Valid @RequestBody DeliveryInputDTO deliveryInputDTO) {
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInputDTO);
        Delivery deliveryRequest = orderService.requestDelivery(newDelivery);

        return deliveryMapper.toDeliveryDTO(deliveryRequest);
    }

    @GetMapping
    public List<DeliveryDTO> deliveryList() {
        return deliveryMapper.deliveryDTOList(deliveryRepository.findAll());

    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDTO> findById (@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toDeliveryDTO(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/delivery/{deliveryId}/finalization")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizeDelivery(@PathVariable Long deliveryId) {
        finalizeDeliveryService.finalizeDelivery(deliveryId);

    }



}
