package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public record ClientController(ClientService clientService) {

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public void registerClient(@RequestBody ClientDTO clientDTO) {
        clientService.registerClient(clientDTO);
    }
}
