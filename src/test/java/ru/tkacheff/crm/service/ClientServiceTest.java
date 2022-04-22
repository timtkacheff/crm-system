package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.dto.mapper.ClientMapper;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.exception.ClientNotFoundException;
import ru.tkacheff.crm.repository.ClientRepository;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void shouldSaveClientUsingGivenDTO() {

        ClientDTO clientDTO = new ClientDTO("John", "88888");

        Client client = clientService.registerClient(clientDTO);

        verify(clientRepository).save(client);

    }

    @Test
    void shouldInvokeFindAllMethod() {
        clientService.getAllClients();
        verify(clientRepository).findAll();
    }

    @Test
    void shouldReturnClientById() {
        Client expected = new Client("test", "8788");

        when(clientRepository.findById(anyInt())).thenReturn(Optional.of(expected));

        Client client = clientService.getClientById(anyInt());

        verify(clientRepository).findById(anyInt());
        assertThat(client).isEqualTo(expected);
    }

    @Test
    void shouldThrowClientNotFoundException() {
        assertThatThrownBy(() -> clientService.getClientById(anyInt()))
                .isInstanceOf(ClientNotFoundException.class);
    }

    @Test
    void shouldUpdateClient() {

        ClientDTO dtoSource = new ClientDTO("", "");
        Client source = new Client();

        when(clientMapper.fromDTO(dtoSource)).thenReturn(source);

        Client target = new Client();

        when(clientRepository.findById(1)).thenReturn(Optional.of(target));

        clientService.updateClient(dtoSource, 1);
        verify(clientRepository).save(target);
        
    }
    @Test
    void shouldDeleteClient() {
        Client underTest = new Client();

        when(clientRepository.findById(1)).thenReturn(Optional.of(underTest));

        clientService.deleteClient(1);
        verify(clientRepository).delete(underTest);
    }
}
