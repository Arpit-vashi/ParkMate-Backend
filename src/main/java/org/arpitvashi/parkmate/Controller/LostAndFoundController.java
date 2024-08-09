package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Dto.LostAndFoundDTO;
import org.arpitvashi.parkmate.Service.LostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/LostAndFound")
public class LostAndFoundController {

    private final LostAndFoundService lostAndFoundService;

    @Autowired
    public LostAndFoundController(LostAndFoundService lostAndFoundService) {
        this.lostAndFoundService = lostAndFoundService;
    }

    @GetMapping
    public ResponseEntity<List<LostAndFoundDTO>> getAllLostAndFounds() {
        List<LostAndFoundDTO> lostAndFounds = lostAndFoundService.getAllLostAndFounds();
        return new ResponseEntity<>(lostAndFounds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostAndFoundDTO> getLostAndFoundById(@PathVariable("id") Long id) {
        LostAndFoundDTO lostAndFounds = lostAndFoundService.getLostAndFoundById(id);
        return new ResponseEntity<>(lostAndFounds, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LostAndFoundDTO> createLostAndFound(@RequestBody LostAndFoundDTO lostAndFoundDTO) {
        LostAndFoundDTO createdLostAndFound = lostAndFoundService.createLostAndFound(lostAndFoundDTO);
        return new ResponseEntity<>(createdLostAndFound, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LostAndFoundDTO> updateLostAndFound(@PathVariable("id") Long id, @RequestBody LostAndFoundDTO lostAndFoundDTO) {
        lostAndFoundDTO.setItemId(id);
        LostAndFoundDTO updatedLostAndFound = lostAndFoundService.updateLostAndFound(id, lostAndFoundDTO);
        return new ResponseEntity<>(updatedLostAndFound, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLostAndFound(@PathVariable("id") Long id) {
        lostAndFoundService.deleteLostAndFound(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
