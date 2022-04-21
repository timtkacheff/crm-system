package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.tkacheff.crm.validation.PhoneNumber;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MasterDTO {

    @Size(min = 2, message = "Name field can't be less than two letters")
    private String name;

    @PhoneNumber
    private String phoneNumber;

    @NotBlank(message = "Specialization field can't be empty")
    private String specialization;

    @Min(value = 1, message = "Hourly rate field can`t be less than 1 dollar")
    private Double hourlyRate;
}
