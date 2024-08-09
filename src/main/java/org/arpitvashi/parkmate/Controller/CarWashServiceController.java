package org.arpitvashi.parkmate.Controller;

import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.CarWashServiceDTO;
import org.arpitvashi.parkmate.Service.CarWashServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CarWashService")
public class CarWashServiceController {

    private final CarWashServiceService carWashServiceService;

    @Autowired
    public CarWashServiceController(CarWashServiceService carWashServiceService) {
        this.carWashServiceService = carWashServiceService;
    }

    @GetMapping
    public ResponseEntity<List<CarWashServiceDTO>> getAllCarWashServices() {
        List<CarWashServiceDTO> carWashServices = carWashServiceService.getAllCarWashServices();
        return new ResponseEntity<>(carWashServices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarWashServiceDTO> getCarWashServiceById(@PathVariable("id") Long id) {
        CarWashServiceDTO carWashServices = carWashServiceService.getCarWashServiceById(id);
        return new ResponseEntity<>(carWashServices, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarWashServiceDTO> createCarWashService(@Valid @RequestBody CarWashServiceDTO carWashServiceDTO) {
        CarWashServiceDTO createdCarWashService = carWashServiceService.createCarWashService(carWashServiceDTO);
        return ResponseEntity.ok(createdCarWashService);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CarWashServiceDTO> updateCarWashService(@PathVariable("id") Long id, @RequestBody CarWashServiceDTO carWashServiceDTO) {
        carWashServiceDTO.setCarWashId(id);
        CarWashServiceDTO updatedCarWashService = carWashServiceService.updateCarWashService(id, carWashServiceDTO);
        return new ResponseEntity<>(updatedCarWashService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarWashService(@PathVariable("id") Long id) {
        carWashServiceService.deleteCarWashService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
