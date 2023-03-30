package com.ancalaghon.ancalog.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInputDTO {

    @NotBlank
    private String description;
}
