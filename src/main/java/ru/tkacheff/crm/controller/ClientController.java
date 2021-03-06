package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public record ClientController(ClientService clientService) {

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client registerClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.registerClient(clientDTO);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Integer id,
                               @RequestBody @Valid ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
