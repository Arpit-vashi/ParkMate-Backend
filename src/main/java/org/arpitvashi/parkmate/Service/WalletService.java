package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.WalletDTO;

import java.util.List;

public interface WalletService {

    WalletDTO createWallet(Long userId); // Create a wallet for the user

    WalletDTO getWalletByUserId(Long userId); // Get wallet by user ID

    WalletDTO getWalletById(Long walletId); // Get wallet by wallet ID

    WalletDTO getUserByWalletId(Long walletId); // Get user by wallet ID

    List<WalletDTO> getAllWallets(); // Get all wallets

    WalletDTO addBalance(Long userId, double amount); // Add balance to the wallet

    WalletDTO updateWallet(Long walletId, WalletDTO walletDTO); // Update wallet details

    WalletDTO updateCardDetails(Long userId, String cardNumber, String cardPin); // Update card details

    void freezeWallet(Long walletId); // Freeze the wallet

    void disableWallet(Long walletId); // Disable the wallet
}
