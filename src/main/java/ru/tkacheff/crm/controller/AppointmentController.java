package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
public record AppointmentController(AppointmentService appointmentService) {

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

}
