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
        dto.setLocation(model.getLocation());
        dto.setCapacity(model.getCapacity());
        return dto;
    }

    public static ParkingLotModel toEntity(ParkingLotDTO dto) {
        ParkingLotModel model = new ParkingLotModel();
        model.setParkingLotId(dto.getParkingLotId());
        model.setName(dto.getName());
        model.setLocation(dto.getLocation());
        model.setCapacity(dto.getCapacity());
        return model;
    }



}
