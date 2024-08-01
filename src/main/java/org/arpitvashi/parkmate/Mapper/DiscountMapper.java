package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.DiscountDTO;
import org.arpitvashi.parkmate.Model.DiscountModel;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {

    public DiscountDTO toDTO(DiscountModel model) {
        DiscountDTO dto = new DiscountDTO();
        dto.setDiscountId(model.getDiscountId());
        dto.setCode(model.getCode());
        dto.setDescription(model.getDescription());
        dto.setDiscountPercentage(model.getDiscountPercentage());
        dto.setValidFrom(model.getValidFrom());
        dto.setValidTo(model.getValidTo());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static DiscountModel toEntity(DiscountDTO dto) {
        DiscountModel model = new DiscountModel();
        model.setDiscountId(dto.getDiscountId());
        model.setCode(dto.getCode());
        model.setDescription(dto.getDescription());
        model.setDiscountPercentage(dto.getDiscountPercentage());
        model.setValidFrom(dto.getValidFrom());
        model.setValidTo(dto.getValidTo());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
