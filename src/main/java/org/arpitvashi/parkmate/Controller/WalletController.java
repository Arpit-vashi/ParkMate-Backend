package org.arpitvashi.parkmate.Controller;

import org.arpitvashi.parkmate.Dto.WalletDTO;
import org.arpitvashi.parkmate.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<WalletDTO> createWallet(@PathVariable Long userId) {
        WalletDTO walletDTO = walletService.createWallet(userId);
        return ResponseEntity.ok(walletDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<WalletDTO> getWalletByUserId(@PathVariable Long userId) {
        WalletDTO walletDTO = walletService.getWalletByUserId(userId);
        return ResponseEntity.ok(walletDTO);
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<WalletDTO> getWalletById(@PathVariable Long walletId) {
        WalletDTO walletDTO = walletService.getWalletById(walletId);
        return ResponseEntity.ok(walletDTO);
    }

    @GetMapping("/wallet/{walletId}/user")
    public ResponseEntity<WalletDTO> getUserByWalletId(@PathVariable Long walletId) {
        WalletDTO walletDTO = walletService.getUserByWalletId(walletId);
        return ResponseEntity.ok(walletDTO);
    }

    @GetMapping
    public ResponseEntity<List<WalletDTO>> getAllWallets() {
        List<WalletDTO> wallets = walletService.getAllWallets();
        return ResponseEntity.ok(wallets);
    }

    @PostMapping("/{userId}/balance")
    public ResponseEntity<WalletDTO> addBalance(@PathVariable Long userId, @RequestParam double amount) {
        WalletDTO walletDTO = walletService.addBalance(userId, amount);
        return ResponseEntity.ok(walletDTO);
    }

    @PutMapping("/{walletId}")
    public ResponseEntity<WalletDTO> updateWallet(@PathVariable Long walletId, @RequestBody WalletDTO walletDTO) {
        WalletDTO updatedWallet = walletService.updateWallet(walletId, walletDTO);
        return ResponseEntity.ok(updatedWallet);
    }

    @PutMapping("/{userId}/card")
    public ResponseEntity<WalletDTO> updateCardDetails(@PathVariable Long userId, @RequestParam String cardNumber, @RequestParam String cardPin) {
        WalletDTO updatedWallet = walletService.updateCardDetails(userId, cardNumber, cardPin);
        return ResponseEntity.ok(updatedWallet);
    }

    @PutMapping("/{walletId}/freeze")
    public ResponseEntity<Void> freezeWallet(@PathVariable Long walletId) {
        walletService.freezeWallet(walletId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{walletId}/disable")
    public ResponseEntity<Void> disableWallet(@PathVariable Long walletId) {
        walletService.disableWallet(walletId);
        return ResponseEntity.noContent().build();
    }
}
