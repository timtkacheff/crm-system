package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.service.AppointmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/appointments")
public record AppointmentController(AppointmentService appointmentService) {

    @GetMapping
    public List<Appointment> getAllAppointments(@RequestParam(name = "status", required = false)
                                                String status) {
        if (status != null) return appointmentService.getAppointmentListByStatus(status);
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Appointment createNewAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return appointmentService.createNewAppointment(appointmentDTO);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointmentStatus(@PathVariable int id,
                                               @RequestParam(name = "status") String status) {
        return appointmentService.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
    }
}
