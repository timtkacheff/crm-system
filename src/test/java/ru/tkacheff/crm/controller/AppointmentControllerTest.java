package ru.tkacheff.crm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tkacheff.crm.AppointmentStatus;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.AppointmentService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {

    //language=JSON
    private final String jsonBody = "{\n" +
            "  \"clientId\": 1,\n" +
            "  \"masterId\": 1,\n" +
            "  \"duration\": 5\n" +
            "}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentService appointmentService;

    @Test
    void shouldReturnAllAppointmentsWithOkStatus() throws Exception {
        List<Appointment> appointments =
                List.of(new Appointment(new Client(), new Master(), 3, 30.0, AppointmentStatus.FINISHED));

        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointments"))
                .andExpect(jsonPath("$[0].duration").value(3))
                .andExpect(jsonPath("$[0].price").value(30.0))
                .andExpect(status().isOk());

    }

    @Test
    void shouldReturnAppointmentByIdSuccessfully() throws Exception {
        Appointment appointment =
                new Appointment(new Client(), new Master(), 3, 30.0, AppointmentStatus.FINISHED);

        when(appointmentService.getAppointmentById(1)).thenReturn(appointment);

        mockMvc.perform(get("/api/v1/appointments/1"))
                .andExpect(jsonPath("$.duration").value(3))
                .andExpect(jsonPath("$.price").value(30.0))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateNewAppointmentSuccessfully() throws Exception {
        mockMvc.perform(post("/api/v1/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateStatusSuccessfully() throws Exception {
        mockMvc.perform(put("/api/v1/appointments/1?status=finished"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldEndWith400StatusCode() throws Exception {
        mockMvc.perform(put("/api/v1/appointments/1"))
                .andExpect(status().is(400));
    }

    @Test
    void shouldDeleteAppointmentSuccessfully() throws Exception {
        mockMvc.perform(delete("/api/v1/appointments/1"))
                .andExpect(status().isOk());
    }
}
