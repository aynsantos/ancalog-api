package com.ancalaghon.ancalog.controller;

import com.ancalaghon.ancalog.dto.OccurrenceDTO;
import com.ancalaghon.ancalog.dto.input.OccurrenceInputDTO;
import com.ancalaghon.ancalog.mapper.OccurrenceMapper;
import com.ancalaghon.ancalog.model.Delivery;
import com.ancalaghon.ancalog.model.Occurrence;
import com.ancalaghon.ancalog.service.RecordOccurrenceService;
import com.ancalaghon.ancalog.service.SearchDeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/occurrences")
@Api(tags = "Occurrence Controller")
public class OccurrenceController {

    private RecordOccurrenceService recordOccurrenceService;
    private OccurrenceMapper occurrenceMapper;
    private SearchDeliveryService searchDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Register Ocurrences By Delivery Id")
    public OccurrenceDTO register (@PathVariable Long deliveryId,
                                   @Valid @RequestBody OccurrenceInputDTO occurrenceInputDTO) {
       Occurrence occurrenceRecord = recordOccurrenceService.record(deliveryId, occurrenceInputDTO.getDescription());

       return occurrenceMapper.toOccurrenceDTO(occurrenceRecord);

    }

    @GetMapping
    @ApiOperation("Ocurrences By Delivery Id")
    public List<OccurrenceDTO> list(@PathVariable Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return occurrenceMapper.occurrenceDTOList(delivery.getOccurrences());
    }


}
