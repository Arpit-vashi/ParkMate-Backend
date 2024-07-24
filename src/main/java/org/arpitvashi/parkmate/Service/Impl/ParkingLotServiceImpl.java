package org.arpitvashi.parkmate.Service.Impl;


import org.arpitvashi.parkmate.Dto.ParkingLotDTO;
import org.arpitvashi.parkmate.Mapper.ParkingLotMapper;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    @Override
    public List<ParkingLotDTO> getAllParkingLots() {
        List<ParkingLotModel> parkingLot = parkingLotRepository.findAll();
        return parkingLot.stream()
                .map(parkingLotMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingLotDTO getParkingLotById(Long id) {
        ParkingLotModel parkingLot = parkingLotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingLot not found with id: " + id));
        return parkingLotMapper.toDTO(parkingLot);
    }

    @Override
    public ParkingLotDTO createParkingLot(ParkingLotDTO parkingLotDTO) {
        ParkingLotModel parkingLot = parkingLotMapper.toEntity(parkingLotDTO);
        ParkingLotModel savedParkingLot = parkingLotRepository.save(parkingLot);
        return parkingLotMapper.toDTO(savedParkingLot);
    }

    @Override
    public ParkingLotDTO updateParkingLot(Long id, ParkingLotDTO parkingLotDTO) {
        ParkingLotModel existingPakingLots = parkingLotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ParkingLot not found with id: " + id));

        if(parkingLotDTO.getName()!=null){
            existingPakingLots.setName(parkingLotDTO.getName());
        }

        if(parkingLotDTO.getLocation()!=null){
            existingPakingLots.setLocation(parkingLotDTO.getLocation());
        }

        if(parkingLotDTO.getCapacity()!=null){
            existingPakingLots.setCapacity(parkingLotDTO.getCapacity());
        }

        ParkingLotModel updateParkingLot = parkingLotRepository.save(existingPakingLots);
        return parkingLotMapper.toDTO(updateParkingLot);
    }

    @Override
    public void deleteParkingLot(Long id) {
        if (!parkingLotRepository.existsById(id)) {
            throw new RuntimeException("ParkingLot not found with id: " + id);
        }
        parkingLotRepository.deleteById(id);
    }



}
