package com.ancalaghon.ancalog.controller;

import com.ancalaghon.ancalog.dto.OccurrenceDTO;
import com.ancalaghon.ancalog.dto.input.OccurrenceInputDTO;
import com.ancalaghon.ancalog.mapper.OccurrenceMapper;
import com.ancalaghon.ancalog.model.Occurrence;
import com.ancalaghon.ancalog.service.RecordOccurrenceService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/occurrences")
@Api(tags = "Occurrence Controller")
public class OccurrenceController {

    private RecordOccurrenceService recordOccurrenceService;
    private OccurrenceMapper occurrenceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceDTO register (@PathVariable Long deliveryId,
                                   @Valid @RequestBody OccurrenceInputDTO occurrenceInputDTO) {
       Occurrence occurrenceRecord = recordOccurrenceService.record(deliveryId, occurrenceInputDTO.getDescription());

       return occurrenceMapper.toOccurrenceDTO(occurrenceRecord);

    }


}
