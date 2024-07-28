package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.ParkingHistoryDTO;
import org.arpitvashi.parkmate.Mapper.ParkingHistoryMapper;
import org.arpitvashi.parkmate.Model.*;
import org.arpitvashi.parkmate.Repository.*;
import org.arpitvashi.parkmate.Service.ParkingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingHistoryServiceImpl implements ParkingHistoryService {

    @Autowired
    private final ParkingHistoryRepository parkingHistoryRepository;

    private final ParkingSpaceRepository parkingSpaceRepository;

    private final VehicleRepository vehicleRepository;

    private final ParkingHistoryMapper parkingHistoryMapper;

    @Autowired
    public ParkingHistoryServiceImpl(ParkingHistoryRepository parkingHistoryRepository, ParkingLotRepository parkingLotRepository, ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository, ParkingHistoryMapper parkingHistoryMapper) {
        this.parkingHistoryRepository = parkingHistoryRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingHistoryMapper = parkingHistoryMapper;
    }

    @Override
    public List<ParkingHistoryDTO> getAllParkingHistories() {
        List<ParkingHistoryModel> parkingHistory = parkingHistoryRepository.findAll();
        return parkingHistory.stream()
                .map(parkingHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingHistoryDTO getParkingHistoryById(Long id) {
        ParkingHistoryModel parkingHistory = parkingHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingHistory not found with id: " + id));
        return parkingHistoryMapper.toDTO(parkingHistory);
    }


    @Override
    public ParkingHistoryDTO createParkingHistory(ParkingHistoryDTO parkingHistoryDTO) {
        if (parkingHistoryDTO.getParkingSpace() == null || parkingHistoryDTO.getVehicle() == null) {
            throw new IllegalArgumentException("ParkingSpace or Vehicle cannot be null");
        }

        ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(parkingHistoryDTO.getParkingSpace().getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));

        VehicleModel vehicle = vehicleRepository.findById(parkingHistoryDTO.getVehicle().getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        ParkingHistoryModel parkingHistory = new ParkingHistoryModel();
        parkingHistory.setEntryTime(parkingHistoryDTO.getEntryTime());
        parkingHistory.setExitTime(parkingHistoryDTO.getExitTime());
        parkingHistory.setVehicle(vehicle);
        parkingHistory.setParkingSpace(parkingSpace);
        parkingHistory.setCreatedAt(new Date());
        parkingHistory.setUpdatedAt(new Date());

        ParkingHistoryModel savedParkingHistory = parkingHistoryRepository.save(parkingHistory);
        return parkingHistoryMapper.toDTO(savedParkingHistory);
    }

    @Override
    public ParkingHistoryDTO updateParkingHistory(Long id, ParkingHistoryDTO parkingHistoryDTO) {
        ParkingHistoryModel existingParkingHistory = parkingHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingHistory not found with id: " + id));

        if(parkingHistoryDTO.getEntryTime()!=null){
            existingParkingHistory.setEntryTime(parkingHistoryDTO.getEntryTime());
        }

        if(parkingHistoryDTO.getExitTime()!=null){
            existingParkingHistory.setExitTime(parkingHistoryDTO.getExitTime());
        }

        if (parkingHistoryDTO.getVehicle() != null) {
            VehicleModel vehicle = vehicleRepository.findById(parkingHistoryDTO.getVehicle().getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            existingParkingHistory.setVehicle(vehicle);
        }

        if (parkingHistoryDTO.getParkingSpace() != null) {
            ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(parkingHistoryDTO.getParkingSpace().getParkingSpaceId())
                    .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));
            existingParkingHistory.setParkingSpace(parkingSpace);
        }

        if(parkingHistoryDTO.getCreatedAt()!=null){
            existingParkingHistory.setCreatedAt(parkingHistoryDTO.getCreatedAt());
        }
        if(parkingHistoryDTO.getUpdatedAt()!=null){
            existingParkingHistory.setUpdatedAt(parkingHistoryDTO.getUpdatedAt());
        }

        ParkingHistoryModel updatedParkingHistory = parkingHistoryRepository.save(existingParkingHistory);
        return parkingHistoryMapper.toDTO(updatedParkingHistory);
    }

    @Override
    public void deleteParkingHistory(Long id) {
        if (!parkingHistoryRepository.existsById(id)) {
            throw new RuntimeException("ParkingHistory not found with id: " + id);
        }
        parkingHistoryRepository.deleteById(id);
    }



}
