package com.ancalaghon.ancalog.controller;

import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.service.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
@Api(tags = "Delivery Controller")
public class DeliveryController {

    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request (@RequestBody Delivery delivery) {
        return orderService.requestDelivery(delivery);
    }

}
