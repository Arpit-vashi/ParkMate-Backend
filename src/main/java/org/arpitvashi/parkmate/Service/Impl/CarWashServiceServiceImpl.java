package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.CarWashServiceDTO;
import org.arpitvashi.parkmate.Mapper.CarWashServiceMapper;
import org.arpitvashi.parkmate.Model.BookingModel;
import org.arpitvashi.parkmate.Model.CarWashServiceModel;
import org.arpitvashi.parkmate.Repository.BookingRepository;
import org.arpitvashi.parkmate.Repository.CarWashServiceRepository;
import org.arpitvashi.parkmate.Service.CarWashServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarWashServiceServiceImpl implements CarWashServiceService {
    @Autowired
    private final CarWashServiceRepository carWashServiceRepository;

    private final BookingRepository bookingRepository;
    private final CarWashServiceMapper carWashServiceMapper;

    @Autowired
    public CarWashServiceServiceImpl(CarWashServiceRepository carWashServiceRepository, BookingRepository bookingRepository, CarWashServiceMapper carWashServiceMapper) {
        this.carWashServiceRepository = carWashServiceRepository;
        this.bookingRepository = bookingRepository;
        this.carWashServiceMapper = carWashServiceMapper;
    }

    @Override
    public List<CarWashServiceDTO> getAllCarWashServices() {
        List<CarWashServiceModel> carWashServices = carWashServiceRepository.findAll();
        return carWashServices.stream()
                .map(carWashServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarWashServiceDTO getCarWashServiceById(Long id) {
        CarWashServiceModel carWashService = carWashServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarWashService not found with id: " + id));
        return carWashServiceMapper.toDTO(carWashService);
    }

    @Override
    public CarWashServiceDTO createCarWashService(CarWashServiceDTO carWashServiceDTO) {
        if (carWashServiceDTO.getBooking() == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }

        BookingModel booking = bookingRepository.findById(carWashServiceDTO.getBooking().getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        CarWashServiceModel carWashService = new CarWashServiceModel();
        carWashService.setServiceType(carWashServiceDTO.getServiceType());
        carWashService.setServiceCost(carWashServiceDTO.getServiceCost());
        carWashService.setBooking(booking);
        carWashService.setCreatedAt(new Date());
        carWashService.setUpdatedAt(new Date());

        CarWashServiceModel savedCarWashService = carWashServiceRepository.save(carWashService);
        return carWashServiceMapper.toDTO(savedCarWashService);
    }

    @Override
    public CarWashServiceDTO updateCarWashService(Long id, CarWashServiceDTO carWashServiceDTO) {
        CarWashServiceModel existingCarWashService = carWashServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CarWashService not found with id: " + id));

        if(carWashServiceDTO.getServiceType()!=null){
            existingCarWashService.setServiceType(carWashServiceDTO.getServiceType());
        }
        if(carWashServiceDTO.getServiceCost()!=null){
            existingCarWashService.setServiceCost(carWashServiceDTO.getServiceCost());
        }
        if (carWashServiceDTO.getBooking() != null) {
            BookingModel booking = bookingRepository.findById(carWashServiceDTO.getBooking().getBookingId())
                    .orElseThrow(() -> new RuntimeException("Booking not found"));
            existingCarWashService.setBooking(booking);
        }
        if(carWashServiceDTO.getCreatedAt()!=null){
            existingCarWashService.setCreatedAt(carWashServiceDTO.getCreatedAt());
        }
        if(carWashServiceDTO.getUpdatedAt()!=null){
            existingCarWashService.setUpdatedAt(carWashServiceDTO.getUpdatedAt());
        }

        existingCarWashService.setUpdatedAt(new Date());
        CarWashServiceModel updatedCarWashService = carWashServiceRepository.save(existingCarWashService);
        return carWashServiceMapper.toDTO(updatedCarWashService);
    }

    @Override
    public void deleteCarWashService(Long id) {
        if (!carWashServiceRepository.existsById(id)) {
            throw new RuntimeException("CarWashService not found with id: " + id);
        }
        carWashServiceRepository.deleteById(id);
    }

}
