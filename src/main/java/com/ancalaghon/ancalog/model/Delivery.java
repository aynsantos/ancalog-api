package com.ancalaghon.ancalog.model;


import com.ancalaghon.ancalog.exception.BusinessException;
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
    @OneToMany (mappedBy = "delivery", cascade = CascadeType.ALL)
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

    public void finalizeDelivery() {
        if (!canBeFinished()) {
            throw new BusinessException("Entrega não pode ser finalizada");
        }

        setStatus(DeliveryStatus.FINISHED);
        setOrderFinished(OffsetDateTime.now());
    }

    public boolean canBeFinished() {
        return DeliveryStatus.PENDING.equals(getStatus());
    }

    public boolean cannotBeFinished() {
        return !canBeFinished();
    }
}
