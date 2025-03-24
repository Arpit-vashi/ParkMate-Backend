package org.arpitvashi.parkmate.Controller;


import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.ParkingRateDTO;
import org.arpitvashi.parkmate.Service.ParkingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingRates")
public class ParkingRateController {

    private final ParkingRateService parkingRateService;

    @Autowired
    public ParkingRateController(ParkingRateService parkingRateService) {
        this.parkingRateService = parkingRateService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingRateDTO>> getAllParkingRates() {
        List<ParkingRateDTO> parkingRates = parkingRateService.getAllParkingRates();
        return new ResponseEntity<>(parkingRates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingRateDTO> getParkingRateById(@PathVariable("id") Long id) {
        ParkingRateDTO parkingRates = parkingRateService.getParkingRateById(id);
        return new ResponseEntity<>(parkingRates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingRateDTO> createParkingRate(@Valid @RequestBody ParkingRateDTO parkingRateDTO) {
        ParkingRateDTO createdParkingRate = parkingRateService.createParkingRate(parkingRateDTO);
        return ResponseEntity.ok(createdParkingRate);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingRateDTO> updateParkingRate(@PathVariable("id") Long id, @RequestBody ParkingRateDTO parkingRateDTO) {
        parkingRateDTO.setRateId(id);
        ParkingRateDTO updatedParkingRate = parkingRateService.updateParkingRate(id, parkingRateDTO);
        return new ResponseEntity<>(updatedParkingRate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingRate(@PathVariable("id") Long id) {
        parkingRateService.deleteParkingRate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
