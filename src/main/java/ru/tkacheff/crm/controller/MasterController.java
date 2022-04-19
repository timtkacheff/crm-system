package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.MasterService;

import java.util.List;

@RestController
@RequestMapping("api/masters")
public record MasterController(MasterService masterService) {

    @PostMapping
    public void registerMaster(@RequestBody MasterDTO masterDTO) {
        masterService.registerMaster(masterDTO);
    }

    @GetMapping
    public List<Master> getAllAvailableMasters() {
        return masterService.getAllMasters();
    }
}
