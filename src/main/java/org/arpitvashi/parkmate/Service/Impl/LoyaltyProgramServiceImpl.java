package org.arpitvashi.parkmate.Service.Impl;


import org.arpitvashi.parkmate.Dto.LoyaltyProgramDTO;
import org.arpitvashi.parkmate.Mapper.LoyaltyProgramMapper;
import org.arpitvashi.parkmate.Model.LoyaltyProgramModel;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Repository.LoyaltyProgramRepository;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    @Autowired
    private final LoyaltyProgramRepository loyaltyProgramRepository;

    private final UserRepository userRepository;
    private final LoyaltyProgramMapper loyaltyProgramMapper;

    @Autowired
    public LoyaltyProgramServiceImpl(LoyaltyProgramRepository loyaltyProgramRepository, UserRepository userRepository, LoyaltyProgramMapper loyaltyProgramMapper) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
        this.userRepository = userRepository;
        this.loyaltyProgramMapper = loyaltyProgramMapper;
    }

    @Override
    public List<LoyaltyProgramDTO> getAllLoyaltyPrograms() {
        List<LoyaltyProgramModel> loyaltyPrograms = loyaltyProgramRepository.findAll();
        return loyaltyPrograms.stream()
                .map(loyaltyProgramMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoyaltyProgramDTO getLoyaltyProgramById(Long id) {
        LoyaltyProgramModel loyaltyPrograms = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoyaltyProgram not found with id: " + id));
        return loyaltyProgramMapper.toDTO(loyaltyPrograms);
    }

    @Override
    public LoyaltyProgramDTO createLoyaltyProgram(LoyaltyProgramDTO loyaltyProgramDTO) {
        if (loyaltyProgramDTO.getUser() == null) {
            throw new IllegalArgumentException("User or VehicleType cannot be null");
        }

        UserModel user = userRepository.findById(loyaltyProgramDTO.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        LoyaltyProgramModel loyaltyProgram = new LoyaltyProgramModel();
        loyaltyProgram.setPoints(loyaltyProgramDTO.getPoints());
        loyaltyProgram.setRewards(loyaltyProgramDTO.getRewards());
        loyaltyProgram.setUser(user);
        loyaltyProgram.setCreatedAt(loyaltyProgramDTO.getCreatedAt());
        loyaltyProgram.setUpdatedAt(loyaltyProgramDTO.getUpdatedAt());
        LoyaltyProgramModel savedLoyaltyProgram = loyaltyProgramRepository.save(loyaltyProgram);

        return loyaltyProgramMapper.toDTO(savedLoyaltyProgram);
    }

    @Override
    public LoyaltyProgramDTO updateLoyaltyProgram(Long id, LoyaltyProgramDTO loyaltyProgramDTO) {
        LoyaltyProgramModel existingLoyaltyProgram = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoyaltyProgram not found with id: " + id));

        if(loyaltyProgramDTO.getPoints()!=null){
            existingLoyaltyProgram.setPoints(loyaltyProgramDTO.getPoints());
        }
        if(loyaltyProgramDTO.getRewards()!= null) {
            existingLoyaltyProgram.setRewards(loyaltyProgramDTO.getRewards());
        }

        if (loyaltyProgramDTO.getUser() != null) {
            UserModel user = userRepository.findById(loyaltyProgramDTO.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existingLoyaltyProgram.setUser(user);
        }
        if(loyaltyProgramDTO.getCreatedAt()!= null) {
            existingLoyaltyProgram.setCreatedAt(loyaltyProgramDTO.getCreatedAt());
        }
        if(loyaltyProgramDTO.getUpdatedAt()!= null) {
            existingLoyaltyProgram.setUpdatedAt(loyaltyProgramDTO.getUpdatedAt());
        }

        LoyaltyProgramModel updatedLoyaltyProgram = loyaltyProgramRepository.save(existingLoyaltyProgram);
        return loyaltyProgramMapper.toDTO(updatedLoyaltyProgram);
    }

    @Override
    public void deleteLoyaltyProgram(Long id) {
        if (!loyaltyProgramRepository.existsById(id)) {
            throw new RuntimeException("LoyaltyProgram not found with id: " + id);
        }
        loyaltyProgramRepository.deleteById(id);
    }


}
