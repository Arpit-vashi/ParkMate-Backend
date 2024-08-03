package org.arpitvashi.parkmate.Controller;


import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.MaintenanceDTO;
import org.arpitvashi.parkmate.Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceDTO>> getAllMaintenances() {
        List<MaintenanceDTO> maintenances = maintenanceService.getAllMaintenances();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> getMaintenanceById(@PathVariable("id") Long id) {
        MaintenanceDTO maintenances = maintenanceService.getMaintenanceById(id);
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenanceDTO> createMaintenance(@Valid @RequestBody MaintenanceDTO maintenanceDTO) {
        MaintenanceDTO createdMaintenance = maintenanceService.createMaintenance(maintenanceDTO);
        return ResponseEntity.ok(createdMaintenance);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> updateMaintenance(@PathVariable("id") Long id, @RequestBody MaintenanceDTO maintenanceDTO) {
        maintenanceDTO.setMaintenanceId(id);
        MaintenanceDTO updatedMaintenance = maintenanceService.updateMaintenance(id, maintenanceDTO);
        return new ResponseEntity<>(updatedMaintenance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable("id") Long id) {
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
