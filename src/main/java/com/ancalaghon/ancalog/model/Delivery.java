package com.ancalaghon.ancalog.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


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
    @OneToMany (mappedBy = "delivery")
    private List<Occurrence> occurrences = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private OffsetDateTime orderTimeStamp;
    private OffsetDateTime orderFinished;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setTimeStamp(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }
}
