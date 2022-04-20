package ru.tkacheff.crm.service;

import org.springframework.stereotype.Service;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
