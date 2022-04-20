package ru.tkacheff.crm.dto.mapper;

import org.springframework.stereotype.Component;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.entity.Client;

@Component
public class ClientMapper {

    public Client fromDTO(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();
    }

}
