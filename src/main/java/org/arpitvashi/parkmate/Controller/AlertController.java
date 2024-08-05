package org.arpitvashi.parkmate.Controller;

import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.AlertDTO;
import org.arpitvashi.parkmate.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<AlertDTO>> getAllAlerts() {
        List<AlertDTO> alerts = alertService.getAllAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> getAlertById(@PathVariable("id") Long id) {
        AlertDTO alerts = alertService.getAlertById(id);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlertDTO> createAlert(@Valid @RequestBody AlertDTO alertDTO) {
        AlertDTO createdAlert = alertService.createAlert(alertDTO);
        return ResponseEntity.ok(createdAlert);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> updateAlert(@PathVariable("id") Long id, @RequestBody AlertDTO alertDTO) {
        alertDTO.setAlertId(id);
        AlertDTO updatedAlert = alertService.updateAlert(id, alertDTO);
        return new ResponseEntity<>(updatedAlert, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable("id") Long id) {
        alertService.deleteAlert(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
