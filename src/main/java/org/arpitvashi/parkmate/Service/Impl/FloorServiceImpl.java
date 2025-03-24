package org.arpitvashi.parkmate.Service.Impl;


import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Mapper.FloorMapper;
import org.arpitvashi.parkmate.Model.*;
import org.arpitvashi.parkmate.Repository.FloorRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private final FloorRepository floorRepository;

    private final ParkingLotRepository parkingLotRepository;
    private final FloorMapper floorMapper;

    @Autowired
    public FloorServiceImpl(FloorRepository floorRepository, ParkingLotRepository parkingLotRepository, FloorMapper floorMapper) {
        this.floorRepository = floorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.floorMapper = floorMapper;
    }

    @Override
    public List<FloorDTO> getAllFloors() {
        List<FloorModel> floors = floorRepository.findAll();
        return floors.stream()
                .map(floorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FloorDTO getFloorById(Long id) {
        FloorModel floors = floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found with id: " + id));
        return floorMapper.toDTO(floors);
    }


    @Override
    public FloorDTO createFloor(FloorDTO floorDTO) {
        if (floorDTO.getParkingLot() == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }

        ParkingLotModel parlingLot = parkingLotRepository.findById(floorDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        FloorModel floor = new FloorModel();
        floor.setFloorNumber(floorDTO.getFloorNumber());
        floor.setDescription(floorDTO.getDescription());
        floor.setParkingLot(parlingLot);
        floor.setCreatedAt(new Date());
        floor.setUpdatedAt(new Date());

        FloorModel savedFloor = floorRepository.save(floor);
        return floorMapper.toDTO(savedFloor);
    }

    @Override
    public FloorDTO updateFloor(Long id, FloorDTO floorDTO) {
        FloorModel existingFloor = floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found with id: " + id));

        if(floorDTO.getFloorNumber()!=null){
            existingFloor.setFloorNumber(floorDTO.getFloorNumber());
        }
        if(floorDTO.getDescription()!= null) {
            existingFloor.setDescription(floorDTO.getDescription());
        }
        if (floorDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(floorDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingFloor.setParkingLot(parkingLot);
        }
        if(floorDTO.getCreatedAt()!=null){
            existingFloor.setCreatedAt(floorDTO.getCreatedAt());
        }
        if(floorDTO.getUpdatedAt()!=null){
            existingFloor.setUpdatedAt(floorDTO.getUpdatedAt());
        }

        existingFloor.setUpdatedAt(new Date());
        FloorModel updatedFloor = floorRepository.save(existingFloor);
        return floorMapper.toDTO(updatedFloor);
    }

    @Override
    public void deleteFloor(Long id) {
        if (!floorRepository.existsById(id)) {
            throw new RuntimeException("Floor not found with id: " + id);
        }
        floorRepository.deleteById(id);
    }

}
