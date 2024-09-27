package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, Long> {

    // Find wallet by user ID
    Optional<WalletModel> findByUser_UserId(Long userId);

    // Additional query method to find a wallet by ID
    Optional<WalletModel> findById(Long id);

    // Additional method to find all wallets
    List<WalletModel> findAll();

    // Check if a card number exists
    boolean existsByCardNumber(String cardNumber);
}
