package ru.tkacheff.crm.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.dto.mapper.AppointmentMapper;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.exception.StatusNotFoundException;
import ru.tkacheff.crm.repository.AppointmentRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private AppointmentMapper appointmentMapper;


    @AfterEach
    void tearDown() {
        appointmentRepository.deleteAll();
    }

    @Test
    void shouldSaveClientUsingGivenDTO() {

        AppointmentDTO appointmentDTO = new AppointmentDTO(1, 1, 2);
        Appointment appointment = appointmentService.createNewAppointment(appointmentDTO);

        verify(appointmentRepository).save(appointment);
    }

    @Test
    void shouldInvokeFindAllMethod() {
        appointmentService.getAllAppointments();
        verify(appointmentRepository).findAll();
    }

    @Test
    void shouldReturnClientById() {

        Appointment appointment = new Appointment();

        when(appointmentRepository.findById(anyInt())).thenReturn(Optional.of(appointment));

        Appointment expected = appointmentService.getAppointmentById(anyInt());

        verify(appointmentRepository).findById(anyInt());
        assertThat(expected).isEqualTo(appointment);
    }

    @Test
    void shouldThrowStatusNotFoundException() {
        assertThatThrownBy(() -> appointmentService.getAppointmentListByStatus("status"))
                .isInstanceOf(StatusNotFoundException.class);
    }

    @Test
    void shouldDeleteAppointment() {

        Appointment underTest = new Appointment();

        when(appointmentRepository.findById(1)).thenReturn(Optional.of(underTest));

        appointmentService.deleteAppointment(1);
        verify(appointmentRepository).delete(underTest);
    }
}
