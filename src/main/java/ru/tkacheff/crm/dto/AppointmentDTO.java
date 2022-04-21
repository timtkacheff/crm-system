package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class AppointmentDTO {

    private Integer clientId;

    private Integer masterId;

    @Min(value = 1, message = "Duration field can't be less than 1 hour")
    private Integer duration;

}
