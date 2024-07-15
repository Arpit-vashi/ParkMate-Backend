package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Model.usersModel;
import org.arpitvashi.parkmate.Repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class usersController {

    @Autowired
    private usersRepository usersRepository;

    // Create a new user
    @PostMapping
    public usersModel createUser(@RequestBody usersModel user) {
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return usersRepository.save(user);
    }

    // Get all users
    @GetMapping
    public List<usersModel> getAllUsers() {
        return usersRepository.findAll();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<usersModel> getUserById(@PathVariable Long id) {
        Optional<usersModel> user = usersRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<usersModel> updateUser(@PathVariable Long id, @RequestBody usersModel userDetails) {
        Optional<usersModel> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent()) {
            usersModel user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPasswordHash(userDetails.getPasswordHash());
            user.setEmail(userDetails.getEmail());
            user.setMobileNo(userDetails.getMobileNo());
            user.setRole(userDetails.getRole());
            usersModel updatedUser = usersRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<usersModel> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent()) {
            usersRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get a user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<usersModel> getUserByUsername(@PathVariable String username) {
        Optional<usersModel> user = usersRepository.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<usersModel> getUserByEmail(@PathVariable String email) {
        Optional<usersModel> user = usersRepository.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a user by mobile number
    @GetMapping("/mobileno/{mobileno}")
    public ResponseEntity<usersModel> getUserByMobileNo(@PathVariable Long mobileno) {
        Optional<usersModel> user = usersRepository.findByMobileNo(mobileno);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
