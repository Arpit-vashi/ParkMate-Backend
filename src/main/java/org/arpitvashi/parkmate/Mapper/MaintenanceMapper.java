package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.MaintenanceDTO;
import org.arpitvashi.parkmate.Model.MaintenanceModel;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceMapper {

    public MaintenanceDTO toDTO(MaintenanceModel model) {
        MaintenanceDTO dto = new MaintenanceDTO();
        dto.setMaintenanceId(model.getMaintenanceId());
        dto.setParkingLot(model.getParkingLot());
        dto.setDescription(model.getDescription());
        dto.setScheduledDate(model.getScheduledDate());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static MaintenanceModel toEntity(MaintenanceDTO dto) {
        MaintenanceModel model = new MaintenanceModel();
        model.setMaintenanceId(dto.getMaintenanceId());
        model.setParkingLot(dto.getParkingLot());
        model.setDescription(dto.getDescription());
        model.setScheduledDate(dto.getScheduledDate());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
