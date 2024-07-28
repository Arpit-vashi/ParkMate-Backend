package org.arpitvashi.parkmate.Controller;

import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.SubscriptionDTO;
import org.arpitvashi.parkmate.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> getAllSubscriptions() {
        List<SubscriptionDTO> subscriptions = subscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable("id") Long id) {
        SubscriptionDTO subscriptions = subscriptionService.getSubscriptionById(id);
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@Valid @RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO createdSubscription = subscriptionService.createSubscription(subscriptionDTO);
        return ResponseEntity.ok(createdSubscription);

    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable("id") Long id, @RequestBody SubscriptionDTO subscriptionDTO) {
        subscriptionDTO.setSubscriptionId(id);
        SubscriptionDTO updatedSubscription = subscriptionService.updateSubscription(id, subscriptionDTO);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable("id") Long id) {
        subscriptionService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


