package ru.tkacheff.crm.service;

import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.entity.Appointment;

import java.util.List;

public interface AppointmentServiceInterface {

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentListByStatus(String status);

    Appointment getAppointmentById(int id);

    Appointment createNewAppointment(AppointmentDTO appointmentDTO);

    Appointment updateAppointment(AppointmentDTO appointmentDTO, int id);

    void deleteAppointment(int id);

}
