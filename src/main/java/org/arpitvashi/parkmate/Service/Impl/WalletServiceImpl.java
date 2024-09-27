package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.WalletDTO;
import org.arpitvashi.parkmate.Mapper.WalletMapper;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.WalletModel;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Repository.WalletRepository;
import org.arpitvashi.parkmate.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final WalletMapper walletMapper;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository, UserRepository userRepository, WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public WalletDTO createWallet(Long userId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        WalletModel wallet = new WalletModel();
        wallet.setUser(user);
        wallet.setBalance(0.0); // Initialize with 0 balance
        wallet.setRewardsPoints(0); // Initialize with 0 rewards points
        wallet.setCardNumber(""); // Empty card number initially
        wallet.setCardPin(""); // Empty card pin initially
        wallet.setFrozen(false); // Use setFrozen instead of setIsFrozen
        wallet.setDisabled(false); // Use setDisabled instead of setIsDisabled
        wallet.setCreatedAt(new Date());
        wallet.setUpdatedAt(new Date());

        WalletModel savedWallet = walletRepository.save(wallet);
        return walletMapper.toDTO(savedWallet);
    }

    @Override
    public WalletDTO getWalletByUserId(Long userId) {
        WalletModel wallet = walletRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for user id: " + userId));
        return walletMapper.toDTO(wallet);
    }

    @Override
    public WalletDTO getWalletById(Long walletId) {
        WalletModel wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with id: " + walletId));
        return walletMapper.toDTO(wallet);
    }

    @Override
    public WalletDTO getUserByWalletId(Long walletId) {
        WalletModel wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with id: " + walletId));
        UserModel user = wallet.getUser();
        // Assuming you have a way to convert UserModel to DTO, implement as needed
        // return userMapper.toDTO(user);
        return walletMapper.toDTO(wallet);
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        List<WalletModel> wallets = walletRepository.findAll();
        return wallets.stream().map(walletMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public WalletDTO addBalance(Long userId, double amount) {
        WalletModel wallet = walletRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for user id: " + userId));

        if (wallet.isFrozen() || wallet.isDisabled()) { // Use isFrozen and isDisabled getters
            throw new RuntimeException("Wallet is frozen or disabled, cannot add balance.");
        }

        wallet.setBalance(wallet.getBalance() + amount);
        wallet.setUpdatedAt(new Date());

        WalletModel updatedWallet = walletRepository.save(wallet);
        return walletMapper.toDTO(updatedWallet);
    }

    @Override
    @Transactional
    public WalletDTO updateWallet(Long walletId, WalletDTO walletDTO) {
        WalletModel wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with id: " + walletId));

        wallet.setBalance(walletDTO.getBalance());
        wallet.setRewardsPoints(walletDTO.getRewardsPoints());
        wallet.setCardNumber(walletDTO.getCardNumber());
        wallet.setCardPin(walletDTO.getCardPin());
        wallet.setUpdatedAt(new Date());

        WalletModel updatedWallet = walletRepository.save(wallet);
        return walletMapper.toDTO(updatedWallet);
    }

    @Override
    public WalletDTO updateCardDetails(Long userId, String cardNumber, String cardPin) {
        WalletModel wallet = walletRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for user id: " + userId));

        wallet.setCardNumber(cardNumber);
        wallet.setCardPin(cardPin);
        wallet.setUpdatedAt(new Date());

        WalletModel updatedWallet = walletRepository.save(wallet);
        return walletMapper.toDTO(updatedWallet);
    }

    @Override
    public void freezeWallet(Long walletId) {
        WalletModel wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with id: " + walletId));

        wallet.setFrozen(true); // Use setFrozen instead of setIsFrozen
        wallet.setUpdatedAt(new Date());

        walletRepository.save(wallet);
    }

    @Override
    public void disableWallet(Long walletId) {
        WalletModel wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with id: " + walletId));

        wallet.setDisabled(true); // Use setDisabled instead of setIsDisabled
        wallet.setUpdatedAt(new Date());

        walletRepository.save(wallet);
    }
}
