package com.ancalaghon.ancalog.dto;

import com.ancalaghon.ancalog.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private String clientName;
    private RecipientDTO recipient;
    private BigDecimal fee;
    private DeliveryStatus status;
    private OffsetDateTime orderTimeStamp;
    private OffsetDateTime orderFinished;

}
