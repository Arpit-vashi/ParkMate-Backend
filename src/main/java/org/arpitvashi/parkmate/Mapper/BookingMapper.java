package org.arpitvashi.parkmate.Mapper;


import org.arpitvashi.parkmate.Dto.BookingDTO;
import org.arpitvashi.parkmate.Model.BookingModel;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDTO toDTO(BookingModel model) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(model.getBookingId());
        dto.setStartTime(model.getStartTime());
        dto.setEndTime(model.getEndTime());
        dto.setBookingStatus(model.getBookingStatus());
        dto.setParkingLot(model.getParkingLot());
        dto.setParkingSpace(model.getParkingSpace());
        dto.setVehicle(model.getVehicle());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static BookingModel toEntity(BookingDTO dto) {
        BookingModel model = new BookingModel();
        model.setBookingId(dto.getBookingId());
        model.setStartTime(dto.getStartTime());
        model.setEndTime(dto.getEndTime());
        model.setBookingStatus(dto.getBookingStatus());
        model.setParkingLot(dto.getParkingLot());
        model.setParkingSpace(dto.getParkingSpace());
        model.setVehicle(dto.getVehicle());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }


}
