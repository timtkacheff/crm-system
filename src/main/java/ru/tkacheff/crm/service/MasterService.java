package ru.tkacheff.crm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.dto.mapper.MasterMapper;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.exception.MasterNotFoundException;
import ru.tkacheff.crm.repository.MasterRepository;

import java.util.List;

@Service
public class MasterService implements MasterServiceInterface{

    private final MasterRepository masterRepository;
    private final MasterMapper masterMapper;

    public MasterService(MasterRepository masterRepository, MasterMapper masterMapper) {
        this.masterRepository = masterRepository;
        this.masterMapper = masterMapper;
    }

    @Override
    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    public Master getMasterById(Integer id) {
        return masterRepository.findById(id)
                .orElseThrow(() -> new MasterNotFoundException("Master with id " + id + " not found"));
    }

    @Override
    public Master registerMaster(MasterDTO masterDTO) {

        Master master = masterMapper.fromDTO(masterDTO);

        return masterRepository.save(master);

    }

    @Override
    public Master updateMaster(MasterDTO masterDTO, Integer id) {

        Master masterToUpdate = getMasterById(id);

        Master masterSource = masterMapper.fromDTO(masterDTO);

        BeanUtils.copyProperties(masterSource, masterToUpdate);

        return masterRepository.save(masterToUpdate);
    }

    @Override
    public void deleteMaster(Integer id) {
        Master masterToDelete = getMasterById(id);
        masterRepository.delete(masterToDelete);
    }
}
