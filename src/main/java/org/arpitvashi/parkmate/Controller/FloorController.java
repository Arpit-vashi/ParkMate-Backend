package org.arpitvashi.parkmate.Controller;


import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.VehicleDTO;
import org.arpitvashi.parkmate.Service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/floors")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping
    public ResponseEntity<List<FloorDTO>> getAllFloors() {
        List<FloorDTO> floors = floorService.getAllFloors();
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FloorDTO> getFloorById(@PathVariable("id") Long id) {
        FloorDTO floors = floorService.getFloorById(id);
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<FloorDTO> createFloor(@RequestBody FloorDTO floorDTO) {
        FloorDTO createdFloor = floorService.createFloor(floorDTO);
        return new ResponseEntity<>(createdFloor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FloorDTO> updateFloor(@PathVariable("id") Long id, @RequestBody FloorDTO floorDTO) {
        floorDTO.setFloorId(id);
        FloorDTO updatedFloor = floorService.updateFloor(id, floorDTO);
        return new ResponseEntity<>(updatedFloor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable("id") Long id) {
        floorService.deleteFloor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
