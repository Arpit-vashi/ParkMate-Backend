package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.ParkingSpaceDTO;
import org.arpitvashi.parkmate.Model.FloorModel;
import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpaceMapper {

    public ParkingSpaceDTO toDTO(ParkingSpaceModel model) {
        ParkingSpaceDTO dto = new ParkingSpaceDTO();
        dto.setParkingSpaceId(model.getParkingSpaceId());
        dto.setSpaceNumber(model.getSpaceNumber());
        dto.setIsOccupied(model.getIsOccupied());
        dto.setIsEVCharging(model.getIsEVCharging());
        dto.setFloor(model.getFloor());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ParkingSpaceModel toEntity(ParkingSpaceDTO dto) {
        ParkingSpaceModel model = new ParkingSpaceModel();
        model.setParkingSpaceId(dto.getParkingSpaceId());
        model.setSpaceNumber(dto.getSpaceNumber());
        model.setIsOccupied(dto.getIsOccupied());
        model.setIsEVCharging(dto.getIsEVCharging());
        model.setFloor(dto.getFloor());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
