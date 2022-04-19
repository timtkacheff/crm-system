package ru.tkacheff.crm.service;

import org.springframework.stereotype.Service;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements ClientServiceInterface{

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void registerClient(ClientDTO clientDTO) {

        Client client = Client.builder()
                .name(clientDTO.getName())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();

        clientRepository.save(client);
    }
}
