package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.ValetServiceDTO;
import org.arpitvashi.parkmate.Mapper.ValetServiceMapper;
import org.arpitvashi.parkmate.Model.BookingModel;
import org.arpitvashi.parkmate.Model.ValetServiceModel;
import org.arpitvashi.parkmate.Repository.BookingRepository;
import org.arpitvashi.parkmate.Repository.ValetServiceRepository;
import org.arpitvashi.parkmate.Service.ValetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValetServiceServiceImpl implements ValetServiceService {

    @Autowired
    private final ValetServiceRepository valetServiceRepository;

    private final BookingRepository bookingRepository;
    private final ValetServiceMapper valetServiceMapper;

    @Autowired
    public ValetServiceServiceImpl(ValetServiceRepository valetServiceRepository, BookingRepository bookingRepository, ValetServiceMapper valetServiceMapper) {
        this.valetServiceRepository = valetServiceRepository;
        this.bookingRepository = bookingRepository;
        this.valetServiceMapper = valetServiceMapper;
    }

    @Override
    public List<ValetServiceDTO> getAllValetServices() {
        List<ValetServiceModel> valetServices = valetServiceRepository.findAll();
        return valetServices.stream()
                .map(valetServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ValetServiceDTO getValetServiceById(Long id) {
        ValetServiceModel valetServices = valetServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ValetService not found with id: " + id));
        return valetServiceMapper.toDTO(valetServices);
    }

    @Override
    public ValetServiceDTO createValetService(ValetServiceDTO valetServiceDTO) {
        if (valetServiceDTO.getBooking() == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }

        BookingModel booking = bookingRepository.findById(valetServiceDTO.getBooking().getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        ValetServiceModel valetService = new ValetServiceModel();
        valetService.setValetCharge(valetServiceDTO.getValetCharge());
        valetService.setBooking(booking);
        valetService.setCreatedAt(new Date());
        valetService.setUpdatedAt(new Date());

        ValetServiceModel savedValetService = valetServiceRepository.save(valetService);
        return valetServiceMapper.toDTO(savedValetService);
    }

    @Override
    public ValetServiceDTO updateValetService(Long id, ValetServiceDTO valetServiceDTO) {
        ValetServiceModel existingValetService = valetServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ValetService not found with id: " + id));

        if(valetServiceDTO.getValetCharge()!=null){
            existingValetService.setValetCharge(valetServiceDTO.getValetCharge());
        }

        if (valetServiceDTO.getBooking() != null) {
            BookingModel booking = bookingRepository.findById(valetServiceDTO.getBooking().getBookingId())
                    .orElseThrow(() -> new RuntimeException("Booking not found"));
            existingValetService.setBooking(booking);
        }
        if(valetServiceDTO.getCreatedAt()!=null){
            existingValetService.setCreatedAt(valetServiceDTO.getCreatedAt());
        }
        if(valetServiceDTO.getUpdatedAt()!=null){
            existingValetService.setUpdatedAt(valetServiceDTO.getUpdatedAt());
        }

        existingValetService.setUpdatedAt(new Date());
        ValetServiceModel updatedValetService = valetServiceRepository.save(existingValetService);
        return valetServiceMapper.toDTO(updatedValetService);
    }

    @Override
    public void deleteValetService(Long id) {
        if (!valetServiceRepository.existsById(id)) {
            throw new RuntimeException("ValetService not found with id: " + id);
        }
        valetServiceRepository.deleteById(id);
    }

}
