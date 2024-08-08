package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.EVChargingStationDTO;
import org.arpitvashi.parkmate.Mapper.EVChargingStationMapper;
import org.arpitvashi.parkmate.Model.EVChargingStationModel;
import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.arpitvashi.parkmate.Repository.*;
import org.arpitvashi.parkmate.Service.EVChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EVChargingStationServiceImpl implements EVChargingStationService {

    @Autowired
    private final EVChargingStationRepository evChargingStationRepository;

    private final ParkingSpaceRepository parkingSpaceRepository;

    private final EVChargingStationMapper evChargingStationMapper;

    @Autowired
    public EVChargingStationServiceImpl(EVChargingStationRepository evChargingStationRepository, ParkingSpaceRepository parkingSpaceRepository, EVChargingStationMapper evChargingStationMapper) {
        this.evChargingStationRepository = evChargingStationRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.evChargingStationMapper = evChargingStationMapper;
    }

    @Override
    public List<EVChargingStationDTO> getAllEVChargingStations() {
        List<EVChargingStationModel> evChargingStations = evChargingStationRepository.findAll();
        return evChargingStations.stream()
                .map(evChargingStationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EVChargingStationDTO getEVChargingStationById(Long id) {
        EVChargingStationModel evChargingStation = evChargingStationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EVChargingStation not found with id: " + id));
        return evChargingStationMapper.toDTO(evChargingStation);
    }

    @Override
    public EVChargingStationDTO createEVChargingStation(EVChargingStationDTO evChargingStationDTO) {
        if (evChargingStationDTO.getParkingSpace() == null) {
            throw new IllegalArgumentException("ParkingSpace cannot be null");
        }

        ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(evChargingStationDTO.getParkingSpace().getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));

        EVChargingStationModel evChargingStation = new EVChargingStationModel();
        evChargingStation.setIsOccupied(evChargingStationDTO.getIsOccupied());
        evChargingStation.setParkingSpace(parkingSpace);
        evChargingStation.setCreatedAt(new Date());
        evChargingStation.setUpdatedAt(new Date());

        EVChargingStationModel savedEVChargingStation = evChargingStationRepository.save(evChargingStation);
        return evChargingStationMapper.toDTO(savedEVChargingStation);
    }

    @Override
    public EVChargingStationDTO updateEVChargingStation(Long id, EVChargingStationDTO evChargingStationDTO) {
        EVChargingStationModel existingEVChargingStation = evChargingStationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EVChargingStation not found with id: " + id));

        if(evChargingStationDTO.getIsOccupied()!=null){
            existingEVChargingStation.setIsOccupied(evChargingStationDTO.getIsOccupied());
        }

        if (evChargingStationDTO.getParkingSpace() != null) {
            ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(evChargingStationDTO.getParkingSpace().getParkingSpaceId())
                    .orElseThrow(() -> new RuntimeException("ParkingSpace not found"));
            existingEVChargingStation.setParkingSpace(parkingSpace);
        }

        if(evChargingStationDTO.getCreatedAt()!=null){
            existingEVChargingStation.setCreatedAt(evChargingStationDTO.getCreatedAt());
        }
        if(evChargingStationDTO.getUpdatedAt()!=null){
            existingEVChargingStation.setUpdatedAt(evChargingStationDTO.getUpdatedAt());
        }

        EVChargingStationModel updatedEVChargingStation = evChargingStationRepository.save(existingEVChargingStation);
        return evChargingStationMapper.toDTO(updatedEVChargingStation);
    }

    @Override
    public void deleteEVChargingStation(Long id) {
        if (!evChargingStationRepository.existsById(id)) {
            throw new RuntimeException("EVChargingStation not found with id: " + id);
        }
        evChargingStationRepository.deleteById(id);
    }

}
