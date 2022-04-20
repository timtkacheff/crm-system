package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.AppointmentDTO;
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

    @PostMapping
    public Appointment createNewAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.createNewAppointment(appointmentDTO);
    }



}
