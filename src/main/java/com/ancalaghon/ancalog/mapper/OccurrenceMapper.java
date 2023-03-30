package com.ancalaghon.ancalog.mapper;

import com.ancalaghon.ancalog.dto.OccurrenceDTO;
import com.ancalaghon.ancalog.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceDTO toOccurrenceDTO (Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }
}
