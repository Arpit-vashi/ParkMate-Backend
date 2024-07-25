package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.ParkingRateDTO;
import org.arpitvashi.parkmate.Mapper.ParkingRateMapper;
import org.arpitvashi.parkmate.Model.*;
import org.arpitvashi.parkmate.Repository.*;
import org.arpitvashi.parkmate.Service.ParkingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingRateServiceImpl implements ParkingRateService {

    @Autowired
    private final ParkingRateRepository parkingRateRepository;

    private final ParkingLotRepository parkingLotRepository;


    private final VehicleTypesRepository vehicleTypesRepository;

    private final ParkingRateMapper parkingRateMapper;

    @Autowired
    public ParkingRateServiceImpl(ParkingRateRepository parkingRateRepository, ParkingLotRepository parkingLotRepository, VehicleTypesRepository vehicleTypesRepository, ParkingRateMapper parkingRateMapper) {
        this.parkingRateRepository = parkingRateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleTypesRepository = vehicleTypesRepository;
        this.parkingRateMapper = parkingRateMapper;
    }

    @Override
    public List<ParkingRateDTO> getAllParkingRates() {
        List<ParkingRateModel> parkingRates = parkingRateRepository.findAll();
        return parkingRates.stream()
                .map(parkingRateMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingRateDTO getParkingRateById(Long id) {
        ParkingRateModel parkingRates = parkingRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingRate not found with id: " + id));
        return parkingRateMapper.toDTO(parkingRates);
    }

    @Override
    public ParkingRateDTO createParkingRate(ParkingRateDTO parkingRateDTO) {
        if (parkingRateDTO.getParkingLot() == null || parkingRateDTO.getVehicleType() == null) {
            throw new IllegalArgumentException("ParkingLot or VehicleType cannot be null");
        }

        ParkingLotModel parkingLot = parkingLotRepository.findById(parkingRateDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        VehicleTypesModel vehicleType = vehicleTypesRepository.findById(parkingRateDTO.getVehicleType().getVehicletypeId())
                .orElseThrow(() -> new RuntimeException("Vehicle type not found"));

        ParkingRateModel parkingRate = new ParkingRateModel();
        parkingRate.setRate(parkingRateDTO.getRate());
        parkingRate.setParkingLot(parkingLot);
        parkingRate.setVehicleType(vehicleType);
        parkingRate.setCreatedAt(parkingRateDTO.getCreatedAt());
        parkingRate.setUpdatedAt(parkingRateDTO.getUpdatedAt());

        ParkingRateModel savedParkingRate = parkingRateRepository.save(parkingRate);
        return parkingRateMapper.toDTO(savedParkingRate);
    }

    @Override
    public ParkingRateDTO updateParkingRate(Long id, ParkingRateDTO parkingRateDTO) {
        ParkingRateModel existingParkingRate = parkingRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingRate not found with id: " + id));

        if(parkingRateDTO.getRate()!=null){
            existingParkingRate.setRate(parkingRateDTO.getRate());
        }

        if (parkingRateDTO.getVehicleType() != null) {
            VehicleTypesModel vehicleType = vehicleTypesRepository.findById(parkingRateDTO.getVehicleType().getVehicletypeId())
                    .orElseThrow(() -> new RuntimeException("VehicleType not found"));
            existingParkingRate.setVehicleType(vehicleType);
        }

        if (parkingRateDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(parkingRateDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingParkingRate.setParkingLot(parkingLot);
        }

        if(parkingRateDTO.getCreatedAt()!=null){
            existingParkingRate.setCreatedAt(parkingRateDTO.getCreatedAt());
        }
        if(parkingRateDTO.getUpdatedAt()!=null){
            existingParkingRate.setUpdatedAt(parkingRateDTO.getUpdatedAt());
        }

        ParkingRateModel updatedParkingRate = parkingRateRepository.save(existingParkingRate);
        return parkingRateMapper.toDTO(updatedParkingRate);
    }

    @Override
    public void deleteParkingRate(Long id) {
        if (!parkingRateRepository.existsById(id)) {
            throw new RuntimeException("ParkingRate not found with id: " + id);
        }
        parkingRateRepository.deleteById(id);
    }



}
