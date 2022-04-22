package ru.tkacheff.crm.controller;

import org.springframework.web.bind.annotation.*;
import ru.tkacheff.crm.dto.MasterDTO;
import ru.tkacheff.crm.entity.Master;
import ru.tkacheff.crm.service.MasterService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/masters")
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
    public Master registerMaster(@RequestBody @Valid MasterDTO masterDTO) {
        return masterService.registerMaster(masterDTO);
    }

    @PutMapping("/{id}")
    public Master updateMaster(@PathVariable Integer id,
                               @RequestBody @Valid MasterDTO masterDTO) {
        return masterService.updateMaster(masterDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMaster(@PathVariable Integer id) {
        masterService.deleteMaster(id);
    }
}
