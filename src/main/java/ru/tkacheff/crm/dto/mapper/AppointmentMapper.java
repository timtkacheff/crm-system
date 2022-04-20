package ru.tkacheff.crm.dto.mapper;

import org.springframework.stereotype.Component;
import ru.tkacheff.crm.dto.AppointmentDTO;
import ru.tkacheff.crm.entity.Appointment;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.ClientService;
import ru.tkacheff.crm.service.MasterService;

@Component
public class AppointmentMapper {

    private final ClientService clientService;
    private final MasterService masterService;

    public AppointmentMapper(ClientService clientService, MasterService masterService) {
        this.clientService = clientService;
        this.masterService = masterService;
    }

    public Appointment fromDTO(AppointmentDTO appointmentDTO) {

        Client client = clientService.getClientById(appointmentDTO.getClientId());
        Master master = masterService.getMasterById(appointmentDTO.getMasterId());

        Double hourlyRate = master.getHourlyRate();

        return Appointment.builder()
                .client(client)
                .master(master)
                .duration(appointmentDTO.getDuration())
                .price(appointmentDTO.getDuration() * hourlyRate)
                .build();

    }

}
