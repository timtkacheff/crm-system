package ru.tkacheff.crm.dto;

import lombok.Data;

@Data
public class MasterDTO {

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
