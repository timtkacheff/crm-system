package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.dto.mapper.MasterMapper;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MasterServiceTest {

    private MasterServiceInterface masterService;

    @Mock
    private MasterRepository masterRepository;

    @Mock
    private MasterMapper masterMapper;

    @BeforeEach
    void setUp() {
        masterService = new MasterService(masterRepository, masterMapper);
    }

    @AfterEach
    void tearDown() {
        masterRepository.deleteAll();
    }

    @Test
    void shouldSaveMasterUsingGivenDTO() {

        MasterDTO masterDTO = new MasterDTO("test", "num", "testing", 25.0);

        Master master = masterService.registerMaster(masterDTO);

        verify(masterRepository).save(master);

    }

    @Test
    void shouldInvokeFindAllMethod() {
        masterService.getAllMasters();
        verify(masterRepository).findAll();
    }

    @Test
    void shouldReturnMasterById() {
        Master master = new Master("test", "8788", "building", 25.0);

        when(masterRepository.findById(anyInt())).thenReturn(Optional.of(master));

        Master expected = masterService.getMasterById(anyInt());

        verify(masterRepository).findById(anyInt());
        assertThat(expected).isEqualTo(master);
    }
}
