package com.ancalaghon.ancalog.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @Embedded
    private Recipient recipient;
    private BigDecimal fee;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private LocalDateTime orderTimeStamp;
    private LocalDateTime orderFinished;
}
