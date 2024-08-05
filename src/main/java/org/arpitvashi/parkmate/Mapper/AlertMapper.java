package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.AlertDTO;
import org.arpitvashi.parkmate.Model.AlertModel;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper {

    public AlertDTO toDTO(AlertModel model) {
        AlertDTO dto = new AlertDTO();
        dto.setAlertId(model.getAlertId());
        dto.setMessage(model.getMessage());
        dto.setAlertTime(model.getAlertTime());
        dto.setUser(model.getUser());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static AlertModel toEntity(AlertDTO dto) {
        AlertModel model = new AlertModel();
        model.setAlertId(dto.getAlertId());
        model.setMessage(dto.getMessage());
        model.setAlertTime(dto.getAlertTime());
        model.setUser(dto.getUser());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
