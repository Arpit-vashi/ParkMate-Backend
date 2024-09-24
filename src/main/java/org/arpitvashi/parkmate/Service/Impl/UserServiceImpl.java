package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.arpitvashi.parkmate.Mapper.UserMapper;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<UserModel> users = userRepository.findAll(pageable);
        return users.map(userMapper::toDTO);
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        UserModel user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserModel user = userRepository.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByMobileNo(Long mobileNo) {
        UserModel user = userRepository.getUserByMobileNo(mobileNo)
                .orElseThrow(() -> new RuntimeException("User not found with mobileno: " + mobileNo));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByName(String name) {
        UserModel user = userRepository.getUserByName(name)
                .orElseThrow(() -> new RuntimeException("User not found with name: " + name));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (userRepository.existsByMobileNo(userDTO.getMobileNo())) {
            throw new IllegalArgumentException("Mobile number already exists");
        }

        UserModel user = userMapper.toEntity(userDTO);
        UserModel savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if(userDTO.getUsername() != null) {
            existingUser.setUsername(userDTO.getUsername());
        }
        if(userDTO.getPassword() != null) {
            existingUser.setPassword(userDTO.getPassword());
        }
        if(userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }
        if(userDTO.getMobileNo() != null) {
            existingUser.setMobileNo(userDTO.getMobileNo());
        }

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
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean mobileExists(Long mobileNo) {
        return userRepository.existsByMobileNo(mobileNo);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

}
