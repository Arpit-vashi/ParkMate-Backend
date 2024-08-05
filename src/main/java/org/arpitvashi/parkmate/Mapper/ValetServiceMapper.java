package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.ValetServiceDTO;
import org.arpitvashi.parkmate.Model.ValetServiceModel;
import org.springframework.stereotype.Component;

@Component
public class ValetServiceMapper {

    public ValetServiceDTO toDTO(ValetServiceModel model) {
        ValetServiceDTO dto = new ValetServiceDTO();
        dto.setValetId(model.getValetId());
        dto.setValetCharge(model.getValetCharge());
        dto.setBooking(model.getBooking());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ValetServiceModel toEntity(ValetServiceDTO dto) {
        ValetServiceModel model = new ValetServiceModel();
        model.setValetId(dto.getValetId());
        model.setValetCharge(dto.getValetCharge());
        model.setBooking(dto.getBooking());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }
}
