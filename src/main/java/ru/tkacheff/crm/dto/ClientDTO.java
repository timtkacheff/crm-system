package ru.tkacheff.crm.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private String name;

    private String phoneNumber;

    public ClientDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
