package org.arpitvashi.parkmate.Controller;


import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.ParkingSpaceDTO;
import org.arpitvashi.parkmate.Service.FloorService;
import org.arpitvashi.parkmate.Service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingSpaces")
public class ParkingSpaceController {

    private final ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpaceDTO>> getAllParkingSpaces() {
        List<ParkingSpaceDTO> parkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceDTO> getParkingSpaceById(@PathVariable("id") Long id) {
        ParkingSpaceDTO parkingSpaces = parkingSpaceService.getParkingSpaceById(id);
        return new ResponseEntity<>(parkingSpaces, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingSpaceDTO> createParkingSpace(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        ParkingSpaceDTO createdParkingSpace = parkingSpaceService.createParkingSpace(parkingSpaceDTO);
        return new ResponseEntity<>(createdParkingSpace, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpaceDTO> updateParkingSpace(@PathVariable("id") Long id, @RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        parkingSpaceDTO.setParkingSpaceId(id);
        ParkingSpaceDTO updatedParkingSpace = parkingSpaceService.updateParkingSpace(id, parkingSpaceDTO);
        return new ResponseEntity<>(updatedParkingSpace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(@PathVariable("id") Long id) {
        parkingSpaceService.deleteParkingSpace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
