package ru.tkacheff.crm.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class MasterDTO {

    @Size(min = 2, message = "Name can't be less than two letters. Try again.")
    private String name;

    private String phoneNumber;

    private String specialization;

    private Double hourlyRate;

    public MasterDTO(String name, String phoneNumber, String specialization, Double hourlyRate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
    }
}
