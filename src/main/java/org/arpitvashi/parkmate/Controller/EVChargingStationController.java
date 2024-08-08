package org.arpitvashi.parkmate.Controller;

import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.EVChargingStationDTO;
import org.arpitvashi.parkmate.Service.EVChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EVChargingStation")
public class EVChargingStationController {

    private final EVChargingStationService evChargingStationService;

    @Autowired
    public EVChargingStationController(EVChargingStationService evChargingStationService) {
        this.evChargingStationService = evChargingStationService;
    }

    @GetMapping
    public ResponseEntity<List<EVChargingStationDTO>> getAllEVChargingStations() {
        List<EVChargingStationDTO> evChargingStations = evChargingStationService.getAllEVChargingStations();
        return new ResponseEntity<>(evChargingStations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EVChargingStationDTO> getEVChargingStationById(@PathVariable("id") Long id) {
        EVChargingStationDTO evChargingStation = evChargingStationService.getEVChargingStationById(id);
        return new ResponseEntity<>(evChargingStation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EVChargingStationDTO> createEVChargingStation(@Valid @RequestBody EVChargingStationDTO evChargingStationDTO) {
        EVChargingStationDTO createdEVChargingStation = evChargingStationService.createEVChargingStation(evChargingStationDTO);
        return ResponseEntity.ok(createdEVChargingStation);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EVChargingStationDTO> updateEVChargingStation(@PathVariable("id") Long id, @RequestBody EVChargingStationDTO evChargingStationDTO) {
        evChargingStationDTO.setChargingStationId(id);
        EVChargingStationDTO updatedEVChargingStation = evChargingStationService.updateEVChargingStation(id, evChargingStationDTO);
        return new ResponseEntity<>(updatedEVChargingStation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEVChargingStation(@PathVariable("id") Long id) {
        evChargingStationService.deleteEVChargingStation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
