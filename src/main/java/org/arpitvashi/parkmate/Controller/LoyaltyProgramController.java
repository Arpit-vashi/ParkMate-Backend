package org.arpitvashi.parkmate.Controller;


import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.LoyaltyProgramDTO;
import org.arpitvashi.parkmate.Service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loyaltyPrograms")
public class LoyaltyProgramController {

    private final LoyaltyProgramService loyaltyProgramService;

    @Autowired
    public LoyaltyProgramController(LoyaltyProgramService loyaltyProgramService) {
        this.loyaltyProgramService = loyaltyProgramService;
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyProgramDTO>> getAllLoyaltyPrograms() {
        List<LoyaltyProgramDTO> loyaltyPrograms = loyaltyProgramService.getAllLoyaltyPrograms();
        return new ResponseEntity<>(loyaltyPrograms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyProgramDTO> getLoyaltyProgramById(@PathVariable("id") Long id) {
        LoyaltyProgramDTO loyaltyPrograms = loyaltyProgramService.getLoyaltyProgramById(id);
        return new ResponseEntity<>(loyaltyPrograms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoyaltyProgramDTO> createLoyaltyProgram(@Valid @RequestBody LoyaltyProgramDTO loyaltyProgramDTO) {
        LoyaltyProgramDTO createdLoyaltyProgram = loyaltyProgramService.createLoyaltyProgram(loyaltyProgramDTO);
        return ResponseEntity.ok(createdLoyaltyProgram);

    }

    @PutMapping("/{id}")
    public ResponseEntity<LoyaltyProgramDTO> updateLoyaltyProgram(@PathVariable("id") Long id, @RequestBody LoyaltyProgramDTO loyaltyProgramDTO) {
        loyaltyProgramDTO.setLoyaltyId(id);
        LoyaltyProgramDTO updatedLoyaltyProgram = loyaltyProgramService.updateLoyaltyProgram(id, loyaltyProgramDTO);
        return new ResponseEntity<>(updatedLoyaltyProgram, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoyaltyProgram(@PathVariable("id") Long id) {
        loyaltyProgramService.deleteLoyaltyProgram(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
