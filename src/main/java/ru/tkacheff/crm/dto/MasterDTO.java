package ru.tkacheff.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MasterDTO {

    @Size(min = 2, message = "Name can't be less than two letters. Try again.")
    @NotBlank
    private String name;

    private String phoneNumber;

    private String specialization;

    @NotNull
    private Double hourlyRate;
}
