package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.LoyaltyProgramDTO;
import org.arpitvashi.parkmate.Model.LoyaltyProgramModel;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyProgramMapper {

    public LoyaltyProgramDTO toDTO(LoyaltyProgramModel model) {
        LoyaltyProgramDTO dto = new LoyaltyProgramDTO();
        dto.setLoyaltyId(model.getLoyaltyId());
        dto.setPoints(model.getPoints());
        dto.setRewards(model.getRewards());
        dto.setUser(model.getUser());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static LoyaltyProgramModel toEntity(LoyaltyProgramDTO dto) {
        LoyaltyProgramModel model = new LoyaltyProgramModel();
        model.setLoyaltyId(dto.getLoyaltyId());
        model.setPoints(dto.getPoints());
        model.setRewards(dto.getRewards());
        model.setUser(dto.getUser());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
