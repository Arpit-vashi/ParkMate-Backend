package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.CarWashServiceDTO;
import org.arpitvashi.parkmate.Model.CarWashServiceModel;
import org.springframework.stereotype.Component;

@Component
public class CarWashServiceMapper {

    public CarWashServiceDTO toDTO(CarWashServiceModel model) {
        CarWashServiceDTO dto = new CarWashServiceDTO();
        dto.setCarWashId(model.getCarWashId());
        dto.setServiceType(model.getServiceType());
        dto.setServiceCost(model.getServiceCost());
        dto.setBooking(model.getBooking());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static CarWashServiceModel toEntity(CarWashServiceDTO dto) {
        CarWashServiceModel model = new CarWashServiceModel();
        model.setCarWashId(dto.getCarWashId());
        model.setServiceType(dto.getServiceType());
        model.setServiceCost(dto.getServiceCost());
        model.setBooking(dto.getBooking());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
