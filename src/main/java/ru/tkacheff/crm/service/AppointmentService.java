package ru.tkacheff.crm.service;

import org.springframework.stereotype.Service;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.dto.mapper.AppointmentMapper;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createNewAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.fromDTO(appointmentDTO);
        return appointmentRepository.save(appointment);
    }
}
