package com.ancalaghon.ancalog.mapper;

import com.ancalaghon.ancalog.dto.DeliveryDTO;
import com.ancalaghon.ancalog.dto.input.DeliveryInputDTO;
import com.ancalaghon.ancalog.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryDTO toDeliveryDTO(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> deliveryDTOList (List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInputDTO deliveryInputDTO) {
        return modelMapper.map(deliveryInputDTO, Delivery.class);
    }




}
