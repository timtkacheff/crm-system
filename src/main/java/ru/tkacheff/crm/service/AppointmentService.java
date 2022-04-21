package ru.tkacheff.crm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.tkacheff.crm.AppointmentStatus;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.dto.mapper.AppointmentMapper;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.exception.AppointmentNotFoundException;
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
        try {
            AppointmentStatus search = AppointmentStatus.valueOf(status.toUpperCase());
            return appointmentRepository.findAllByStatus(search);
        } catch (IllegalArgumentException e) {
            throw new StatusNotFoundException("'" + status + "'" + " not found");
        }
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
    public Appointment updateAppointment(AppointmentDTO appointmentDTO, int id) {

        Appointment appointmentToUpdate = getAppointmentById(id);
        Appointment appointmentSource = appointmentMapper.fromDTO(appointmentDTO);

        BeanUtils.copyProperties(appointmentSource, appointmentToUpdate);

        return appointmentRepository.save(appointmentToUpdate);
    }

    @Override
    public void deleteAppointment(int id) {
        Appointment appointmentToDelete = getAppointmentById(id);
        appointmentRepository.delete(appointmentToDelete);
    }
}
