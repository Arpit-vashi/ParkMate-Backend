package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.arpitvashi.parkmate.Dto.WalletDTO; // Import WalletDTO
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.CountryModel;
import org.arpitvashi.parkmate.Model.WalletModel; // Import WalletModel
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(UserModel model) {
        if (model == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setUserId(model.getUserId());
        dto.setName(model.getName());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());
        dto.setMobileNo(model.getMobileNo());
        dto.setAddress(model.getAddress());
        dto.setCity(model.getCity());
        dto.setState(model.getState());

        if (model.getCountry() != null) {
            dto.setCountryId(model.getCountry().getId());
            dto.setCountryName(model.getCountry().getName());
        }

        // Handle wallet
        if (model.getWallet() != null) { // Assuming UserModel has a getWallet() method
            WalletModel walletModel = model.getWallet();
            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setCardNumber(walletModel.getCardNumber());
            walletDTO.setCardPin(walletModel.getCardPin());
            walletDTO.setBalance(walletModel.getBalance());
            walletDTO.setRewardsPoints(walletModel.getRewardsPoints());
            walletDTO.setFrozen(walletModel.isFrozen());
            walletDTO.setDisabled(walletModel.isDisabled());
            dto.setWallet(walletDTO);
        }

        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());

        return dto;
    }

    public UserModel toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        UserModel model = new UserModel();
        model.setUserId(dto.getUserId());
        model.setName(dto.getName());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setEmail(dto.getEmail());
        model.setMobileNo(dto.getMobileNo());
        model.setAddress(dto.getAddress());
        model.setCity(dto.getCity());
        model.setState(dto.getState());

        if (dto.getCountryId() != null) {
            CountryModel countryModel = new CountryModel();
            countryModel.setId(dto.getCountryId());
            model.setCountry(countryModel);
        }

        // Handle wallet
        if (dto.getWallet() != null) { // Assuming WalletDTO is not null
            WalletDTO walletDTO = dto.getWallet();
            WalletModel walletModel = new WalletModel(); // Assuming you have a WalletModel
            walletModel.setCardNumber(walletDTO.getCardNumber());
            walletModel.setCardPin(walletDTO.getCardPin());
            walletModel.setBalance(walletDTO.getBalance());
            walletModel.setRewardsPoints(walletDTO.getRewardsPoints());
            walletModel.setFrozen(walletDTO.isFrozen());
            walletModel.setDisabled(walletDTO.isDisabled());
            model.setWallet(walletModel); // Assuming UserModel has a setWallet method
        }

        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());

        return model;
    }
}
