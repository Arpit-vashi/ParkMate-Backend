package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.SubscriptionDTO;
import org.arpitvashi.parkmate.Model.SubscriptionModel;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    public SubscriptionDTO toDTO(SubscriptionModel model) {
        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setSubscriptionId(model.getSubscriptionId());
        dto.setUser(model.getUser());
        dto.setStartDate(model.getStartDate());
        dto.setEndDate(model.getEndDate());
        dto.setSubscriptionType(model.getSubscriptionType());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static SubscriptionModel toEntity(SubscriptionDTO dto) {
        SubscriptionModel model = new SubscriptionModel();
        model.setSubscriptionId(dto.getSubscriptionId());
        model.setUser(dto.getUser());
        model.setStartDate(dto.getStartDate());
        model.setEndDate(dto.getEndDate());
        model.setSubscriptionType(dto.getSubscriptionType());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
