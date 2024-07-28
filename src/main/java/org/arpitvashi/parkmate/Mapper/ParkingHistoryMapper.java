package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.ParkingHistoryDTO;
import org.arpitvashi.parkmate.Model.ParkingHistoryModel;
import org.springframework.stereotype.Component;

@Component
public class ParkingHistoryMapper {

    public ParkingHistoryDTO toDTO(ParkingHistoryModel model) {
        ParkingHistoryDTO dto = new ParkingHistoryDTO();
        dto.setParkingHistoryId(model.getParkingHistoryId());
        dto.setEntryTime(model.getEntryTime());
        dto.setExitTime(model.getExitTime());
        dto.setVehicle(model.getVehicle());
        dto.setParkingSpace(model.getParkingSpace());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ParkingHistoryModel toEntity(ParkingHistoryDTO dto) {
        ParkingHistoryModel model = new ParkingHistoryModel();
        model.setParkingHistoryId(dto.getParkingHistoryId());
        model.setEntryTime(dto.getEntryTime());
        model.setExitTime(dto.getExitTime());
        model.setVehicle(dto.getVehicle());
        model.setParkingSpace(dto.getParkingSpace());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }


}
