package com.ancalaghon.ancalog.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

public class RecipientDTO {

    private String name;
    private String address;
    private String number;
    private String complement;
    private String district;
}
