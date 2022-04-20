package ru.tkacheff.crm.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ClientDTO {
    @Size(min = 2, message = "Name can't be less than two letters. Try again.")
    private String name;
    private String phoneNumber;

    public ClientDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
