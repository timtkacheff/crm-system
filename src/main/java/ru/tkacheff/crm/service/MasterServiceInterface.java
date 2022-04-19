package ru.tkacheff.crm.service;

import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Master;

import java.util.List;

public interface MasterServiceInterface {

    List<Master> getAllMasters();

    Master getMasterById(Integer id);

    Master registerMaster(MasterDTO masterDTO);
}
