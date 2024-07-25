package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.ParkingRateDTO;
import org.arpitvashi.parkmate.Model.ParkingRateModel;
import org.springframework.stereotype.Component;

@Component
public class ParkingRateMapper {

    public ParkingRateDTO toDTO(ParkingRateModel model) {
        ParkingRateDTO dto = new ParkingRateDTO();
        dto.setRateId(model.getRateId());
        dto.setRate(model.getRate());
        dto.setParkingLot(model.getParkingLot());
        dto.setVehicleType(model.getVehicleType());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ParkingRateModel toEntity(ParkingRateDTO dto) {
        ParkingRateModel model = new ParkingRateModel();
        model.setRateId(dto.getRateId());
        model.setRate(dto.getRate());
        model.setParkingLot(dto.getParkingLot());
        model.setVehicleType(dto.getVehicleType());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }


}
