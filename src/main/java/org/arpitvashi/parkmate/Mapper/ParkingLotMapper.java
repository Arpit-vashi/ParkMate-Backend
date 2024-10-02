package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.ParkingLotDTO;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    public ParkingLotDTO toDTO(ParkingLotModel model) {
        ParkingLotDTO dto = new ParkingLotDTO();
        dto.setParkingLotId(model.getParkingLotId());
        dto.setName(model.getName());
        dto.setAddressLine1(model.getAddressLine1());
        dto.setCity(model.getCity());
        dto.setState(model.getState());
        dto.setCountry(model.getCountry());
        dto.setSupportEmail(model.getSupportEmail());
        dto.setSupportMobile(model.getSupportMobile());
        dto.setCapacity(model.getCapacity());
        dto.setFloors(model.getFloors());
        dto.setUsedFloors(model.getUsedFloors());
        dto.setOwners(model.getOwners());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ParkingLotModel toEntity(ParkingLotDTO dto) {
        ParkingLotModel model = new ParkingLotModel();
        model.setParkingLotId(dto.getParkingLotId());
        model.setName(dto.getName());
        model.setAddressLine1(dto.getAddressLine1());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setCountry(dto.getCountry());
        model.setSupportEmail(dto.getSupportEmail());
        model.setSupportMobile(dto.getSupportMobile());
        model.setCapacity(dto.getCapacity());
        model.setFloors(dto.getFloors());
        model.setUsedFloors(dto.getUsedFloors());
        model.setOwners(dto.getOwners());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }
}
