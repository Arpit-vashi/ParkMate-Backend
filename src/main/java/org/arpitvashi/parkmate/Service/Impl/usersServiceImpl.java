package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.usersDto;
import org.arpitvashi.parkmate.Mapper.usersMapper;
import org.arpitvashi.parkmate.Model.usersModel;
import org.arpitvashi.parkmate.Repository.usersRepository;
import org.arpitvashi.parkmate.Service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private usersMapper usersMapper;

    @Override
    public usersDto createUser(usersDto user) {
        // Hash password before saving
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        usersModel userModel = usersMapper.toEntity(user);
        usersModel createdUser = usersRepository.save(userModel);
        return usersMapper.toDto(createdUser);
    }

    @Override
    public List<usersDto> getAllUsers() {
        List<usersModel> users = usersRepository.findAll();
        return usersMapper.toDtoList(users);
    }

    @Override
    public usersDto getUserById(Long id) {
        Optional<usersModel> user = usersRepository.findById(id);
        return user.map(usersMapper::toDto).orElse(null);
    }

    @Override
    public usersDto updateUser(Long id, usersDto userDetails) {
        Optional<usersModel> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent()) {
            usersModel user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setMobileNo(userDetails.getMobileNo());
            user.setRole(userDetails.getRole());

            // You may add more fields here as needed

            usersModel updatedUser = usersRepository.save(user);
            return usersMapper.toDto(updatedUser);
        } else {
            return null; // Or throw an exception indicating user not found
        }
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public usersDto getUserByUsername(String username) {
        Optional<usersModel> user = usersRepository.findByUsername(username);
        return user.map(usersMapper::toDto).orElse(null);
    }

    @Override
    public usersDto getUserByEmail(String email) {
        Optional<usersModel> user = usersRepository.findByEmail(email);
        return user.map(usersMapper::toDto).orElse(null);
    }

    @Override
    public usersDto getUserByMobileNo(Long mobileno) {
        Optional<usersModel> user = usersRepository.findByMobileNo(mobileno);
        return user.map(usersMapper::toDto).orElse(null);
    }
}