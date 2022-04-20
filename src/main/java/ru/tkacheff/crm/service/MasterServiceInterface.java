package ru.tkacheff.crm.service;

import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;

import java.util.List;

public interface MasterServiceInterface {

    List<Master> getAllMasters();

    Master getMasterById(Integer id);

    void registerMaster(MasterDTO masterDTO);

    Master updateMaster(MasterDTO masterDTO, Integer id);

    void deleteMaster(Integer id);
}
