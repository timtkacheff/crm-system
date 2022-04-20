package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.ClientDTO;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Client;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.MasterService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/masters")
public record MasterController(MasterService masterService) {

    @GetMapping
    public List<Master> getAllAvailableMasters() {
        return masterService.getAllMasters();
    }

    @GetMapping("/{id}")
    public Master getMasterById(@PathVariable Integer id) {
        return masterService.getMasterById(id);
    }

    @PostMapping
    public void registerMaster(@RequestBody @Valid MasterDTO masterDTO) {
        masterService.registerMaster(masterDTO);
    }

    @PutMapping("/{id}")
    public Master updateClient(@PathVariable Integer id, @RequestBody MasterDTO masterDTO) {
        return masterService.updateMaster(masterDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMaster(@PathVariable Integer id) {
        masterService.deleteMaster(id);
    }
}
