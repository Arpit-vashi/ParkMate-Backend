package org.arpitvashi.parkmate.Service.Impl;


import org.arpitvashi.parkmate.Dto.BookingDTO;
import org.arpitvashi.parkmate.Mapper.BookingMapper;
import org.arpitvashi.parkmate.Model.*;
import org.arpitvashi.parkmate.Repository.*;
import org.arpitvashi.parkmate.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    private final ParkingLotRepository parkingLotRepository;

    private final ParkingSpaceRepository parkingSpaceRepository;

    private final VehicleRepository vehicleRepository;

    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, ParkingLotRepository parkingLotRepository, ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookingModel> booking = bookingRepository.findAll();
        return booking.stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        BookingModel booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        return bookingMapper.toDTO(booking);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        if (bookingDTO.getParkingLot() == null || bookingDTO.getParkingSpace() == null || bookingDTO.getVehicle() == null) {
            throw new IllegalArgumentException("ParkingLot or ParkingSpace or Vehicle cannot be null");
        }

        ParkingLotModel parkingLot = parkingLotRepository.findById(bookingDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(bookingDTO.getParkingSpace().getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));

        VehicleModel vehicle = vehicleRepository.findById(bookingDTO.getVehicle().getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        BookingModel booking = new BookingModel();
        booking.setStartTime(bookingDTO.getStartTime());
        booking.setEndTime(bookingDTO.getEndTime());
        booking.setBookingStatus(bookingDTO.getBookingStatus());
        booking.setParkingLot(parkingLot);
        booking.setParkingSpace(parkingSpace);
        booking.setVehicle(vehicle);
        booking.setCreatedAt(new Date());
        booking.setUpdatedAt(new Date());

        BookingModel savedBooking = bookingRepository.save(booking);
        return bookingMapper.toDTO(savedBooking);
    }


    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        BookingModel existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        if(bookingDTO.getStartTime()!=null){
            existingBooking.setStartTime(bookingDTO.getStartTime());
        }

        if(bookingDTO.getEndTime()!=null){
            existingBooking.setEndTime(bookingDTO.getEndTime());
        }

        if(bookingDTO.getBookingStatus()!=null){
            existingBooking.setBookingStatus(bookingDTO.getBookingStatus());
        }

        if (bookingDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(bookingDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingBooking.setParkingLot(parkingLot);
        }

        if (bookingDTO.getParkingSpace() != null) {
            ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(bookingDTO.getParkingSpace().getParkingSpaceId())
                    .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));
            existingBooking.setParkingSpace(parkingSpace);
        }

        if (bookingDTO.getVehicle() != null) {
            VehicleModel vehicle = vehicleRepository.findById(bookingDTO.getVehicle().getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            existingBooking.setVehicle(vehicle);
        }

        if(bookingDTO.getCreatedAt()!=null){
            existingBooking.setCreatedAt(bookingDTO.getCreatedAt());
        }
        if(bookingDTO.getUpdatedAt()!=null){
            existingBooking.setUpdatedAt(bookingDTO.getUpdatedAt());
        }

        BookingModel updatedBooking = bookingRepository.save(existingBooking);
        return bookingMapper.toDTO(updatedBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }

}
