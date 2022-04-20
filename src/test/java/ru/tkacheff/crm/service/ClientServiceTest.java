package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.dto.mapper.ClientMapper;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.repository.ClientRepository;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @BeforeEach
    void setUp() {
        clientService = new ClientService(clientRepository, clientMapper);
    }

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void shouldSaveMasterUsingGivenDTO() {

        ClientDTO clientDTO = new ClientDTO("John", "88888");

        clientService.registerClient(clientDTO);

        ArgumentCaptor<Client> masterArgumentCaptor = ArgumentCaptor.forClass(Client.class);

        verify(clientRepository).save(masterArgumentCaptor.capture());
        Client capturedClient = masterArgumentCaptor.getValue();

        assertThat(capturedClient.getName()).isEqualTo(clientDTO.getName());
        assertThat(capturedClient.getPhoneNumber()).isEqualTo(clientDTO.getPhoneNumber());

    }

    @Test
    void shouldInvokeFindAllMethod() {
        clientService.getAllClients();
        verify(clientRepository).findAll();
    }

    @Test
    void shouldReturnMasterById() {
        Client client = new Client("test", "8788");

        when(clientRepository.findById(anyInt())).thenReturn(Optional.of(client));

        Client expected = clientService.getClientById(anyInt());

        verify(clientRepository).findById(anyInt());
        assertThat(expected).isEqualTo(client);
    }
}
