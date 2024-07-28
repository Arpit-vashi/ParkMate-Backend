package org.arpitvashi.parkmate.Controller;



import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.ParkingHistoryDTO;
import org.arpitvashi.parkmate.Service.ParkingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingHistory")
public class ParkingHistoryController {

    private final ParkingHistoryService parkingHistoryService;

    @Autowired
    public ParkingHistoryController(ParkingHistoryService parkingHistoryService) {
        this.parkingHistoryService = parkingHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingHistoryDTO>> getAllParkingHistories() {
        List<ParkingHistoryDTO> parkingHistory = parkingHistoryService.getAllParkingHistories();
        return new ResponseEntity<>(parkingHistory, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingHistoryDTO> getParkingHistoryById(@PathVariable("id") Long id) {
        ParkingHistoryDTO parkingHistory = parkingHistoryService.getParkingHistoryById(id);
        return new ResponseEntity<>(parkingHistory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParkingHistoryDTO> createParkingHistory(@Valid @RequestBody ParkingHistoryDTO parkingHistoryDTO) {
        ParkingHistoryDTO createdParkingHistory = parkingHistoryService.createParkingHistory(parkingHistoryDTO);
        return ResponseEntity.ok(createdParkingHistory);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingHistoryDTO> updateParkingHistory(@PathVariable("id") Long id, @RequestBody ParkingHistoryDTO parkingHistoryDTO) {
        parkingHistoryDTO.setParkingHistoryId(id);
        ParkingHistoryDTO updatedParkingHistory = parkingHistoryService.updateParkingHistory(id, parkingHistoryDTO);
        return new ResponseEntity<>(updatedParkingHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingHistory(@PathVariable("id") Long id) {
        parkingHistoryService.deleteParkingHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
