package ru.tkacheff.crm.dto.mapper;

import org.springframework.stereotype.Component;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Master;

@Component
public class MasterMapper {

    public static Master fromDTO(MasterDTO masterDTO) {
        return Master.builder()
                .name(masterDTO.getName())
                .hourlyRate(masterDTO.getHourlyRate())
                .specialization(masterDTO.getSpecialization())
                .build();
    }
}
