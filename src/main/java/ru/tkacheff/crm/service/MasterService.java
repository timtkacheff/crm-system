package ru.tkacheff.crm.service;

import org.springframework.stereotype.Service;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.List;

@Service
public class MasterService implements MasterServiceInterface{

    private final MasterRepository masterRepository;

    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public Master getMasterById(Integer id) {
        return masterRepository.findById(id).orElse(null);
    }

    @Override
    public Master registerMaster(MasterDTO masterDTO) {

        Master master = Master.builder()
                .name(masterDTO.getName())
                .phoneNumber(masterDTO.getPhoneNumber())
                .specialization(masterDTO.getSpecialization())
                .hourlyRate(masterDTO.getHourlyRate())
                .build();

        masterRepository.save(master);

        return master;
    }
}
