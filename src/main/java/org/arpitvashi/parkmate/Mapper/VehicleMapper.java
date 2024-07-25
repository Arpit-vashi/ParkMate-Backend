package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.VehicleDTO;
import org.arpitvashi.parkmate.Model.VehicleModel;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDTO toDTO(VehicleModel model) {
        VehicleDTO dto = new VehicleDTO();
        dto.setVehicleId(model.getVehicleId());
        dto.setLicensePlate(model.getLicensePlate());
        dto.setIsElectric(model.getIsElectric());
        dto.setVehicleType(model.getVehicleType());
        dto.setUser(model.getUser());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static VehicleModel toEntity(VehicleDTO dto) {
        VehicleModel model = new VehicleModel();
        model.setVehicleId(dto.getVehicleId());
        model.setLicensePlate(dto.getLicensePlate());
        model.setIsElectric(dto.getIsElectric());
        model.setVehicleType(dto.getVehicleType());
        model.setUser(dto.getUser());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }
}
