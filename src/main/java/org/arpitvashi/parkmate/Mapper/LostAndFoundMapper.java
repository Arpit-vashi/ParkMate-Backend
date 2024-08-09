package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.LostAndFoundDTO;
import org.arpitvashi.parkmate.Model.LostAndFoundModel;
import org.springframework.stereotype.Component;

@Component
public class LostAndFoundMapper {

    public LostAndFoundDTO toDTO(LostAndFoundModel model) {
        LostAndFoundDTO dto = new LostAndFoundDTO();
        dto.setItemId(model.getItemId());
        dto.setDescription(model.getDescription());
        dto.setFoundAt(model.getFoundAt());
        dto.setClaimed(model.getClaimed());
        dto.setParkingLot(model.getParkingLot());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static LostAndFoundModel toEntity(LostAndFoundDTO dto) {
        LostAndFoundModel model = new LostAndFoundModel();
        model.setItemId(dto.getItemId());
        model.setDescription(dto.getDescription());
        model.setFoundAt(dto.getFoundAt());
        model.setClaimed(dto.getClaimed());
        model.setParkingLot(dto.getParkingLot());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
