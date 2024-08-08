package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.EVChargingStationDTO;
import org.arpitvashi.parkmate.Model.EVChargingStationModel;
import org.springframework.stereotype.Component;

@Component
public class EVChargingStationMapper {

    public EVChargingStationDTO toDTO(EVChargingStationModel model) {
        EVChargingStationDTO dto = new EVChargingStationDTO();
        dto.setChargingStationId(model.getChargingStationId());
        dto.setIsOccupied(model.getIsOccupied());
        dto.setParkingSpace(model.getParkingSpace());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static EVChargingStationModel toEntity(EVChargingStationDTO dto) {
        EVChargingStationModel model = new EVChargingStationModel();
        model.setChargingStationId(dto.getChargingStationId());
        model.setIsOccupied(dto.getIsOccupied());
        model.setParkingSpace(dto.getParkingSpace());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
