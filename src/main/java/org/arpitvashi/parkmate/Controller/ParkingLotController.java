package org.arpitvashi.parkmate.Controller;


import org.arpitvashi.parkmate.Dto.ParkingLotDTO;
import org.arpitvashi.parkmate.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingLots")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLots() {
        List<ParkingLotDTO> parkingLots = parkingLotService.getAllParkingLots();
        return new ResponseEntity<>(parkingLots, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotById(@PathVariable("id") Long id) {
        ParkingLotDTO parkingLots = parkingLotService.getParkingLotById(id);
        return new ResponseEntity<>(parkingLots, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingLotDTO> createParkingLot(@RequestBody ParkingLotDTO parkingLotDTO) {
        ParkingLotDTO createParkingLot = parkingLotService.createParkingLot(parkingLotDTO);
        return new ResponseEntity<>(createParkingLot, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingLotDTO> updateParkingLot(@PathVariable("id") Long id, @RequestBody ParkingLotDTO parkingLotDTO) {
        parkingLotDTO.setParkingLotId(id);
        ParkingLotDTO updateParkingLot = parkingLotService.updateParkingLot(id, parkingLotDTO);
        return new ResponseEntity<>(updateParkingLot, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingLot(@PathVariable("id") Long id) {
        parkingLotService.deleteParkingLot(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
