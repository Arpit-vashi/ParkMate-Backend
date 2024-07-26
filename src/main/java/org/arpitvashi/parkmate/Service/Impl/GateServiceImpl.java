package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.GateDTO;
import org.arpitvashi.parkmate.Mapper.GateMapper;
import org.arpitvashi.parkmate.Model.GateModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.GateRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GateServiceImpl implements GateService {

    @Autowired
    private final GateRepository gateRepository;

    private final ParkingLotRepository parkingLotRepository;

    private final GateMapper gateMapper;

    @Autowired
    public GateServiceImpl(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, GateMapper gateMapper) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateMapper = gateMapper;
    }

    @Override
    public List<GateDTO> getAllGates() {
        List<GateModel> gates = gateRepository.findAll();
        return gates.stream()
                .map(gateMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GateDTO getGateById(Long id) {
        GateModel gate = gateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gate not found with id: " + id));
        return gateMapper.toDTO(gate);
    }

    @Override
    public GateDTO createGate(GateDTO gateDTO) {
        if (gateDTO.getParkingLot() == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }

        ParkingLotModel parkingLot = parkingLotRepository.findById(gateDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));


        GateModel gate = new GateModel();
        gate.setGateType(gateDTO.getGateType());
        gate.setParkingLot(parkingLot);
        gate.setCreatedAt(gateDTO.getCreatedAt());
        gate.setUpdatedAt(gateDTO.getUpdatedAt());

        GateModel savedGate = gateRepository.save(gate);
        return gateMapper.toDTO(savedGate);
    }

    @Override
    public GateDTO updateGate(Long id, GateDTO gateDTO) {
        GateModel existingGate = gateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gate not found with id: " + id));

        if(gateDTO.getGateType()!=null){
            existingGate.setGateType(gateDTO.getGateType());
        }

        if (gateDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(gateDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingGate.setParkingLot(parkingLot);
        }

        if(gateDTO.getCreatedAt()!=null){
            existingGate.setCreatedAt(gateDTO.getCreatedAt());
        }
        if(gateDTO.getUpdatedAt()!=null){
            existingGate.setUpdatedAt(gateDTO.getUpdatedAt());
        }

        GateModel updatedGate = gateRepository.save(existingGate);
        return gateMapper.toDTO(updatedGate);
    }

    @Override
    public void deleteGate(Long id) {
        if (!gateRepository.existsById(id)) {
            throw new RuntimeException("Gate not found with id: " + id);
        }
        gateRepository.deleteById(id);
    }


}
