package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.WalletDTO;
import org.arpitvashi.parkmate.Model.WalletModel;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    // Convert WalletModel to WalletDTO
    public WalletDTO toDTO(WalletModel walletModel) {
        if (walletModel == null) {
            return null;
        }

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(walletModel.getId());
        walletDTO.setUserId(walletModel.getUser().getUserId());
        walletDTO.setBalance(walletModel.getBalance());
        walletDTO.setRewardsPoints(walletModel.getRewardsPoints());
        walletDTO.setCardNumber(walletModel.getCardNumber());
        walletDTO.setCardPin(walletModel.getCardPin());
        walletDTO.setFrozen(walletModel.isFrozen()); // Map isFrozen
        walletDTO.setDisabled(walletModel.isDisabled()); // Map isDisabled

        return walletDTO;
    }

    // Convert WalletDTO to WalletModel
    public WalletModel toEntity(WalletDTO walletDTO) {
        if (walletDTO == null) {
            return null;
        }

        WalletModel walletModel = new WalletModel();
        walletModel.setId(walletDTO.getId());
        walletModel.setBalance(walletDTO.getBalance());
        walletModel.setRewardsPoints(walletDTO.getRewardsPoints());
        walletModel.setCardNumber(walletDTO.getCardNumber());
        walletModel.setCardPin(walletDTO.getCardPin());
        walletModel.setFrozen(walletDTO.isFrozen()); // Set isFrozen
        walletModel.setDisabled(walletDTO.isDisabled()); // Set isDisabled

        // Set UserModel (Assuming you have a method to fetch user by ID)
        // Uncomment and implement if necessary
        /*
        UserModel user = userRepository.findById(walletDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + walletDTO.getUserId()));
        walletModel.setUser(user);
        */

        return walletModel;
    }
}
