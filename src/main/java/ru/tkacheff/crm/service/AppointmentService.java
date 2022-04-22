package ru.tkacheff.crm.service;

import org.springframework.stereotype.Service;
import ru.tkacheff.crm.AppointmentStatus;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.dto.mapper.AppointmentMapper;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.exception.AppointmentNotFoundException;
import ru.tkacheff.crm.exception.FinisedStatusChangeException;
import ru.tkacheff.crm.exception.StatusNotFoundException;
import ru.tkacheff.crm.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {

    private final AppointmentRepository appointmentRepository;

    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentListByStatus(String status) {
        AppointmentStatus search = convertStringToStatus(status);
        return appointmentRepository.findAllByStatus(search);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id" + id + " not found"));
    }

    @Override
    public Appointment createNewAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.fromDTO(appointmentDTO);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointmentStatus(int id, String input) {
        Appointment appointment = getAppointmentById(id);

        if (appointment.getStatus() == AppointmentStatus.FINISHED) {
            throw new FinisedStatusChangeException("Appointment already finished");
        }

        AppointmentStatus status = convertStringToStatus(input);
        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        Appointment appointmentToDelete = getAppointmentById(id);
        appointmentRepository.delete(appointmentToDelete);
    }

    private AppointmentStatus convertStringToStatus(String input) {
        try {
            return AppointmentStatus.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new StatusNotFoundException("'" + input + "'" + " not found");
        }
    }

}
