package ru.tkacheff.crm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.mapper.ClientMapper;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.exception.ClientNotFoundException;
import ru.tkacheff.crm.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements ClientServiceInterface {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository,
                         ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new ClientNotFoundException("Client with id " + id + " not found"));
    }

    @Override
    public Client registerClient(ClientDTO clientDTO) {

        Client client = clientMapper.fromDTO(clientDTO);

        return  clientRepository.save(client);
    }

    @Override
    public Client updateClient(ClientDTO clientDTO, Integer id) {

        Client clientToUpdate = getClientById(id);
        Client clientSource = clientMapper.fromDTO(clientDTO);

        BeanUtils.copyProperties(clientSource, clientToUpdate);

        return clientRepository.save(clientToUpdate);
    }

    @Override
    public void deleteClient(Integer id) {
        Client clientToDelete = getClientById(id);
        clientRepository.delete(clientToDelete);
    }
}
