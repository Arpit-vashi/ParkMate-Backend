package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Dto.VehicleTypesDTO;
import org.arpitvashi.parkmate.Service.VehicleTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicletypes")
public class VehicleTypesController {

    private final VehicleTypesService vehicleTypesService;

    @Autowired
    public VehicleTypesController(VehicleTypesService vehicleTypesService) {
        this.vehicleTypesService = vehicleTypesService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleTypesDTO>> getAllVehicleTypes() {
        List<VehicleTypesDTO> vehicleTypes = vehicleTypesService.getAllVehicleTypes();
        return new ResponseEntity<>(vehicleTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypesDTO> getVehicleTypesById(@PathVariable("id") Long id) {
        VehicleTypesDTO vehicleTypes = vehicleTypesService.getVehicleTypesById(id);
        return new ResponseEntity<>(vehicleTypes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleTypesDTO> createVehicleTypes(@RequestBody VehicleTypesDTO vehicleTypesDTO) {
        VehicleTypesDTO createdVehicleTypes = vehicleTypesService.createVehicleTypes(vehicleTypesDTO);
        return new ResponseEntity<>(createdVehicleTypes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleTypesDTO> updateVehicleTypes(@PathVariable("id") Long id, @RequestBody VehicleTypesDTO vehicleTypesDTO) {
        vehicleTypesDTO.setVehicletypeId(id);
        VehicleTypesDTO updatedVehicleTypes = vehicleTypesService.updateVehicleTypes(id, vehicleTypesDTO);
        return new ResponseEntity<>(updatedVehicleTypes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleTypes(@PathVariable("id") Long id) {
        vehicleTypesService.deleteVehicleTypes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
