package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.ParkingSpaceDTO;
import org.arpitvashi.parkmate.Mapper.FloorMapper;
import org.arpitvashi.parkmate.Mapper.ParkingSpaceMapper;
import org.arpitvashi.parkmate.Model.FloorModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.arpitvashi.parkmate.Repository.FloorRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Repository.ParkingSpaceRepository;
import org.arpitvashi.parkmate.Service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private final ParkingSpaceRepository parkingSpaceRepository;

    private final FloorRepository floorRepository;
    private final ParkingSpaceMapper parkingSpaceMapper;

    @Autowired
    public ParkingSpaceServiceImpl(ParkingSpaceRepository parkingSpaceRepository, FloorRepository floorRepository, ParkingSpaceMapper parkingSpaceMapper) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.floorRepository = floorRepository;
        this.parkingSpaceMapper = parkingSpaceMapper;
    }

    @Override
    public List<ParkingSpaceDTO> getAllParkingSpaces() {
        List<ParkingSpaceModel> parkingSpace = parkingSpaceRepository.findAll();
        return parkingSpace.stream()
                .map(parkingSpaceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingSpaceDTO getParkingSpaceById(Long id) {
        ParkingSpaceModel parkingSpace = parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found with id: " + id));
        return parkingSpaceMapper.toDTO(parkingSpace);
    }

    @Override
    public ParkingSpaceDTO createParkingSpace(ParkingSpaceDTO parkingSpaceDTO) {
        if (parkingSpaceDTO.getFloor() == null) {
            throw new IllegalArgumentException("Floor cannot be null");
        }

        FloorModel floor = floorRepository.findById(parkingSpaceDTO.getFloor().getFloorId())
                .orElseThrow(() -> new RuntimeException("Floor not found"));

        ParkingSpaceModel parkingSpace = new ParkingSpaceModel();
        parkingSpace.setSpaceNumber(parkingSpaceDTO.getSpaceNumber());
        parkingSpace.setIsOccupied(parkingSpaceDTO.getIsOccupied());
        parkingSpace.setIsEVCharging(parkingSpaceDTO.getIsEVCharging());
        parkingSpace.setFloor(floor);
        parkingSpace.setCreatedAt(new Date());
        parkingSpace.setUpdatedAt(new Date());

        ParkingSpaceModel savedParkingSpace = parkingSpaceRepository.save(parkingSpace);
        return parkingSpaceMapper.toDTO(savedParkingSpace);
    }

    @Override
    public ParkingSpaceDTO updateParkingSpace(Long id, ParkingSpaceDTO parkingSpaceDTO) {
        ParkingSpaceModel existingParkingSpace = parkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingSpace not found with id: " + id));

        if(parkingSpaceDTO.getSpaceNumber()!=null){
            existingParkingSpace.setSpaceNumber(parkingSpaceDTO.getSpaceNumber());
        }
        if(parkingSpaceDTO.getIsOccupied()!= null) {
            existingParkingSpace.setIsOccupied(parkingSpaceDTO.getIsOccupied());
        }
        if(parkingSpaceDTO.getIsEVCharging()!= null) {
            existingParkingSpace.setIsEVCharging(parkingSpaceDTO.getIsEVCharging());
        }
        if (parkingSpaceDTO.getFloor() != null) {
            FloorModel floor = floorRepository.findById(parkingSpaceDTO.getFloor().getFloorId())
                    .orElseThrow(() -> new RuntimeException("Floor not found"));
            existingParkingSpace.setFloor(floor);
        }
        if(parkingSpaceDTO.getCreatedAt()!=null){
            existingParkingSpace.setCreatedAt(parkingSpaceDTO.getCreatedAt());
        }
        if(parkingSpaceDTO.getUpdatedAt()!=null){
            existingParkingSpace.setUpdatedAt(parkingSpaceDTO.getUpdatedAt());
        }

        existingParkingSpace.setUpdatedAt(new Date());
        ParkingSpaceModel updatedParkingSpace = parkingSpaceRepository.save(existingParkingSpace);
        return parkingSpaceMapper.toDTO(updatedParkingSpace);
    }

    @Override
    public void deleteParkingSpace(Long id) {
        if (!parkingSpaceRepository.existsById(id)) {
            throw new RuntimeException("ParkingSpace not found with id: " + id);
        }
        parkingSpaceRepository.deleteById(id);
    }



}
