package ru.tkacheff.crm.service;

import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.entity.Client;

import java.util.List;

public interface ClientServiceInterface {

    List<Client> getAllClients();

    Client getClientById(Integer id);

    Client registerClient(ClientDTO clientDTO);

    Client updateClient(ClientDTO clientDTO, Integer id);

    void deleteClient(Integer id);
}
