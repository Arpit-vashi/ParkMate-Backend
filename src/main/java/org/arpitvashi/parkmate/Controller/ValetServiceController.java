package org.arpitvashi.parkmate.Controller;

import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.ValetServiceDTO;
import org.arpitvashi.parkmate.Service.ValetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valetService")
public class ValetServiceController {

    private final ValetServiceService valetServiceService;

    @Autowired
    public ValetServiceController(ValetServiceService valetServiceService) {
        this.valetServiceService = valetServiceService;
    }

    @GetMapping
    public ResponseEntity<List<ValetServiceDTO>> getAllValetServices() {
        List<ValetServiceDTO> valetServices = valetServiceService.getAllValetServices();
        return new ResponseEntity<>(valetServices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValetServiceDTO> getValetServiceById(@PathVariable("id") Long id) {
        ValetServiceDTO valetServices = valetServiceService.getValetServiceById(id);
        return new ResponseEntity<>(valetServices, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ValetServiceDTO> createValetService(@Valid @RequestBody ValetServiceDTO valetServiceDTO) {
        ValetServiceDTO createdValetService = valetServiceService.createValetService(valetServiceDTO);
        return ResponseEntity.ok(createdValetService);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ValetServiceDTO> updateValetService(@PathVariable("id") Long id, @RequestBody ValetServiceDTO valetServiceDTO) {
        valetServiceDTO.setValetId(id);
        ValetServiceDTO updatedValetService = valetServiceService.updateValetService(id, valetServiceDTO);
        return new ResponseEntity<>(updatedValetService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValetService(@PathVariable("id") Long id) {
        valetServiceService.deleteValetService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
