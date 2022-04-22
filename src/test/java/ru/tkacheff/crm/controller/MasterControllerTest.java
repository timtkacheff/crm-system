package ru.tkacheff.crm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.MasterService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MasterController.class)
public class MasterControllerTest {

    //language=JSON
    private final String masterJsonBody = "{\n" +
            "  \"name\": \"test\",\n" +
            "  \"phoneNumber\": \"89996665544\",\n" +
            "  \"specialization\": \"testing\",\n" +
            "  \"hourlyRate\": 10\n" +
            "}";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MasterService masterService;

    @Test
    void shouldReturnAllMasters() throws Exception {
        List<Master> masters = List.of(new Master("test", "89996665544", "testing", 10.0));

        when(masterService.getAllMasters()).thenReturn(masters);

        mockMvc.perform(get("/api/v1/masters"))
                .andExpect(jsonPath("$[0].name").value("test"))
                .andExpect(jsonPath("$[0].phoneNumber").value("89996665544"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnMasterById() throws Exception {
        Master master = new Master("test", "89996665544", "testing", 10.0);

        when(masterService.getMasterById(1)).thenReturn(master);

        mockMvc.perform(get("/api/v1/masters/1"))
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.phoneNumber").value("89996665544"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRegisterNewMaster() throws Exception {
        mockMvc.perform(post("/api/v1/masters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(masterJsonBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateMasterSuccessfully() throws Exception {
        mockMvc.perform(put("/api/v1/masters/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(masterJsonBody))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteMasterSuccessfully() throws Exception {
        mockMvc.perform(delete("/api/v1/masters/1"))
                .andExpect(status().isOk());
    }
}
