package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class ClientDTO {

    @Size(min = 2, message = "Name can't be less than two letters. Try again.")
    private String name;

    private String phoneNumber;
}
