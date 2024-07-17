package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.VehicleTypesDTO;
import org.arpitvashi.parkmate.Model.VehicleTypesModel;
import org.springframework.stereotype.Component;

@Component
public class VehicleTypesMapper {

    public VehicleTypesDTO toDTO(VehicleTypesModel model) {
        VehicleTypesDTO dto = new VehicleTypesDTO();
        dto.setVehicletypeId(model.getVehicletypeId());
        dto.setTypename(model.getTypename());
        return dto;
    }


    public static VehicleTypesModel toEntity(VehicleTypesDTO dto) {
        VehicleTypesModel model = new VehicleTypesModel();
        model.setVehicletypeId(dto.getVehicletypeId());
        model.setTypename(dto.getTypename());
         return model;
    }

}
