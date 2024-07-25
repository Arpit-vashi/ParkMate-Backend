package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.VehicleDTO;
import org.arpitvashi.parkmate.Model.FloorModel;
import org.arpitvashi.parkmate.Model.VehicleModel;
import org.springframework.stereotype.Component;

@Component
public class FloorMapper {

    public FloorDTO toDTO(FloorModel model) {
        FloorDTO dto = new FloorDTO();
        dto.setFloorId(model.getFloorId());
        dto.setFloorNumber(model.getFloorNumber());
        dto.setDescription(model.getDescription());
        dto.setParkingLot(model.getParkingLot());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static FloorModel toEntity(FloorDTO dto) {
        FloorModel model = new FloorModel();
        model.setFloorId(dto.getFloorId());
        model.setFloorNumber(dto.getFloorNumber());
        model.setDescription(dto.getDescription());
        model.setParkingLot(dto.getParkingLot());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }


}
