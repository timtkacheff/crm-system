package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentDTO {

    private Integer clientId;
    private Integer masterId;
    private Integer duration;

}
