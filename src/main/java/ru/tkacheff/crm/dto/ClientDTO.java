package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.tkacheff.crm.validation.PhoneNumber;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class ClientDTO {

    @Size(min = 2, message = "Name field can't be less than two letters")
    private String name;

    @PhoneNumber
    private String phoneNumber;
}
