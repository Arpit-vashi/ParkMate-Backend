package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.GateDTO;
import org.arpitvashi.parkmate.Model.GateModel;
import org.springframework.stereotype.Component;

@Component
public class GateMapper {

    public GateDTO toDTO(GateModel model) {
        GateDTO dto = new GateDTO();
        dto.setGateId(model.getGateId());
        dto.setGateType(model.getGateType());
        dto.setParkingLot(model.getParkingLot());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static GateModel toEntity(GateDTO dto) {
        GateModel model = new GateModel();
        model.setGateId(dto.getGateId());
        model.setGateType(dto.getGateType());
        model.setParkingLot(dto.getParkingLot());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
