package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.arpitvashi.parkmate.Mapper.UserMapper;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.CountryModel;
import org.arpitvashi.parkmate.Model.WalletModel; // Import WalletModel
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Repository.CountryRepository;
import org.arpitvashi.parkmate.Repository.WalletRepository; // Import WalletRepository
import org.arpitvashi.parkmate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort; // Import for Sort
import org.springframework.data.domain.PageRequest; // Import for PageRequest



import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final UserMapper userMapper;
    private final WalletRepository walletRepository; // Add WalletRepository

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,
                           CountryRepository countryRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.countryRepository = countryRepository;
        this.walletRepository = walletRepository; // Initialize WalletRepository
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public boolean mobileExists(String mobileNo) {
        return userRepository.existsByMobileNo(mobileNo);
    }


    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable, String sortBy, String sortOrder) {
        // Create a Sort object based on the provided parameters
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortBy);
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        // Call the repository to retrieve users with sorting applied
        Page<UserModel> users = userRepository.findAll(sortedPageable);
        return users.map(userMapper::toDTO);
    }


    @Override
    public UserDTO getUserByEmail(String email) {
        return userRepository.getUserByEmail(email)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public UserDTO getUserByName(String name) {
        return userRepository.getUserByName(name)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with name: " + name));
    }


    @Override
    public UserDTO getUserByMobileNo(String mobileNo) {
        return userRepository.getUserByMobileNo(mobileNo)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with mobile number: " + mobileNo));
    }


    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userRepository.getUserByUsername(username)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        validateUserUniqueness(userDTO);

        CountryModel country = countryRepository.findById(userDTO.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + userDTO.getCountryId()));

        UserModel user = userMapper.toEntity(userDTO);
        user.setCountry(country);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        UserModel savedUser = userRepository.save(user);

        // Create and link a new wallet for the user
        WalletModel wallet = new WalletModel();
        wallet.setUser(savedUser);
        wallet.setBalance(0.0); // Initialize balance to 0
        wallet.setRewardsPoints(0); // Initialize rewards points to 0
        wallet.setCardNumber(generateCardNumber()); // Generate a unique card number
        wallet.setCardPin(generateCardPin()); // Generate a secure PIN
        wallet.setCreatedAt(new Date());
        wallet.setUpdatedAt(new Date());

        walletRepository.save(wallet); // Save the wallet to the database

        // Set wallet details in UserDTO as an array
        userDTO.setWalletDetails(List.of(
                "Card Number: " + wallet.getCardNumber(),
                "Card PIN: " + wallet.getCardPin(),
                "Balance: " + wallet.getBalance(),
                "Rewards Points: " + wallet.getRewardsPoints()
        ));

        return userMapper.toDTO(savedUser);
    }



    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        updateUserDetails(existingUser, userDTO);
        existingUser.setUpdatedAt(new Date());

        UserModel updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserDTO> searchUsers(String searchTerm, Pageable pageable) {
        Page<UserModel> users = userRepository.searchUsers(searchTerm, pageable);
        return users.map(userMapper::toDTO);
    }



    // Implementing wallet management methods if needed...

    private void validateUserUniqueness(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (userRepository.existsByMobileNo(userDTO.getMobileNo())) {
            throw new IllegalArgumentException("Mobile number already exists");
        }
    }

    private void updateUserDetails(UserModel existingUser, UserDTO userDTO) {
        if (userDTO.getUsername() != null) {
            existingUser.setUsername(userDTO.getUsername());
        }
        if (userDTO.getPassword() != null) {
            existingUser.setPassword(userDTO.getPassword()); // Consider adding hashing
        }
        if (userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }
        if (userDTO.getMobileNo() != null) {
            existingUser.setMobileNo(userDTO.getMobileNo());
        }
        if (userDTO.getAddress() != null) {
            existingUser.setAddress(userDTO.getAddress());
        }
    }

    private String generateCardNumber() {
        Random random = new Random();
        String cardNumber;
        do {
            cardNumber = String.format("%04d%04d%04d%04d", random.nextInt(10000), random.nextInt(10000), random.nextInt(10000), random.nextInt(10000));
        } while (walletRepository.existsByCardNumber(cardNumber)); // Ensure uniqueness
        return cardNumber;
    }

    private String generateCardPin() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000)); // Generate a 4-digit PIN
    }
}
