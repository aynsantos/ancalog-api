package com.ancalaghon.ancalog.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceDTO {

    private Long id;
    private String description;
    private OffsetDateTime timeStamp;

}
