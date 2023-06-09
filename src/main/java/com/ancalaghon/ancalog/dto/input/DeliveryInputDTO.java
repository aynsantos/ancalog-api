package com.ancalaghon.ancalog.dto.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryInputDTO {

    @Valid
    @NotNull
    private ClientIdInputDTO client;
    @Valid
    @NotNull
    private RecipientInputDTO recipient;
    @NotNull
    private BigDecimal fee;




}
