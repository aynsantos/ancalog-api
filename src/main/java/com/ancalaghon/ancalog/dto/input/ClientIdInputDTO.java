package com.ancalaghon.ancalog.dto.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientIdInputDTO {

    @NotNull
    private Long id;
}
