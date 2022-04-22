package ru.tkacheff.crm.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.tkacheff.crm.entity.Client;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    void setUp() {
        client = Client.builder()
                .name("test")
                .phoneNumber("test")
                .build();
    }

    @Test
    void shouldSaveAndReturnEmployee() {
        Client savedClient = clientRepository.save(client);

        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getId()).isGreaterThan(0);
    }

}
