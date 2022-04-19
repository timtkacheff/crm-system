package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tkacheff.crm.dto.MasterDTO;
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

    @BeforeEach
    void setUp() {
        masterService = new MasterService(masterRepository);
    }

    @AfterEach
    void tearDown() {
        masterRepository.deleteAll();
    }

    @Test
    void shouldSaveMasterUsingGivenDTO() {

        MasterDTO masterDTO = new MasterDTO("test", "num", "testing", 25.0);

        masterService.registerMaster(masterDTO);

        ArgumentCaptor<Master> masterArgumentCaptor = ArgumentCaptor.forClass(Master.class);

        verify(masterRepository).save(masterArgumentCaptor.capture());
        Master capturedMaster = masterArgumentCaptor.getValue();

        assertThat(capturedMaster.getName()).isEqualTo(masterDTO.getName());
        assertThat(capturedMaster.getSpecialization()).isEqualTo(masterDTO.getSpecialization());

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
