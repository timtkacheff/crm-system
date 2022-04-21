package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.dto.mapper.MasterMapper;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MasterServiceTest {

    @InjectMocks
    private MasterService masterService;

    @Mock
    private MasterRepository masterRepository;

    @Mock
    private MasterMapper masterMapper;

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
        Master expected = new Master("test", "8788", "building", 25.0);

        when(masterRepository.findById(anyInt())).thenReturn(Optional.of(expected));

        Master master = masterService.getMasterById(anyInt());

        verify(masterRepository).findById(anyInt());
        assertThat(master).isEqualTo(expected);
    }

    @Test
    void shouldUpdateMaster() {

        MasterDTO dtoSource = new MasterDTO("", "", "", 0.0);
        Master source = new Master();

        when(masterMapper.fromDTO(dtoSource)).thenReturn(source);

        Master target = new Master();

        when(masterRepository.findById(1)).thenReturn(Optional.of(target));

        masterService.updateMaster(dtoSource, 1);
        verify(masterRepository).save(target);

    }

    @Test
    void shouldDeleteMaster() {
        Master underTest = new Master();

        when(masterRepository.findById(1)).thenReturn(Optional.of(underTest));

        masterService.deleteMaster(1);
        verify(masterRepository).delete(underTest);
    }
}
