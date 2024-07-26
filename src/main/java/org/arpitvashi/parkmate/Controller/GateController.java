package org.arpitvashi.parkmate.Controller;


import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.GateDTO;
import org.arpitvashi.parkmate.Service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gates")
public class GateController {

    private final GateService gateService;

    @Autowired
    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping
    public ResponseEntity<List<GateDTO>> getAllGates() {
        List<GateDTO> gates = gateService.getAllGates();
        return new ResponseEntity<>(gates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GateDTO> getGateById(@PathVariable("id") Long id) {
        GateDTO gates = gateService.getGateById(id);
        return new ResponseEntity<>(gates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GateDTO> createGate(@Valid @RequestBody GateDTO gateDTO) {
        GateDTO createdGate = gateService.createGate(gateDTO);
        return ResponseEntity.ok(createdGate);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GateDTO> updateGate(@PathVariable("id") Long id, @RequestBody GateDTO gateDTO) {
        gateDTO.setGateId(id);
        GateDTO updatedGate = gateService.updateGate(id, gateDTO);
        return new ResponseEntity<>(updatedGate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGate(@PathVariable("id") Long id) {
        gateService.deleteGate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
