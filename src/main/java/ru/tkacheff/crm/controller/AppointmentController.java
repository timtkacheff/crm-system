package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.service.AppointmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/appointments")
public record AppointmentController(AppointmentService appointmentService) {

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status) {
        return appointmentService.getAppointmentListByStatus(status);
    }

    @PostMapping
    public Appointment createNewAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return appointmentService.createNewAppointment(appointmentDTO);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointmentById(id);
    }

}
