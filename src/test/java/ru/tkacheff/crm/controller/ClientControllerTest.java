package ru.tkacheff.crm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.service.ClientService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    private final String clientJsonBody = "{" +
            "\"name\":\"test\", " +
            "\"phoneNumber\":\"89996665544\"" +
            "}";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;

    @Test
    void shouldReturnAllClients() throws Exception {
        List<Client> clients = List.of(new Client("test", "89996665544"));

        when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(get("/api/v1/clients"))
                .andExpect(jsonPath("$[0].name").value("test"))
                .andExpect(jsonPath("$[0].phoneNumber").value("89996665544"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnClientById() throws Exception {
        Client client = new Client("test", "89996665544");

        when(clientService.getClientById(1)).thenReturn(client);

        mockMvc.perform(get("/api/v1/clients/1"))
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.phoneNumber").value("89996665544"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRegisterNewClient() throws Exception {
        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientJsonBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateClientSuccessfully() throws Exception {
        mockMvc.perform(put("/api/v1/clients/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientJsonBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteClientSuccessfully() throws Exception {
        mockMvc.perform(delete("/api/v1/clients/1"))
                .andExpect(status().isOk());
    }
}
