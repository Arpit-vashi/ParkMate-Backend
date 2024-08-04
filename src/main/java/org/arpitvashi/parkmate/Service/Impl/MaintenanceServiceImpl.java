package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.MaintenanceDTO;
import org.arpitvashi.parkmate.Mapper.MaintenanceMapper;
import org.arpitvashi.parkmate.Model.MaintenanceModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.MaintenanceRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private final MaintenanceRepository maintenanceRepository;

    private final ParkingLotRepository parkingLotRepository;

    private final MaintenanceMapper maintenanceMapper;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, ParkingLotRepository parkingLotRepository, MaintenanceMapper maintenanceMapper) {
        this.maintenanceRepository = maintenanceRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.maintenanceMapper = maintenanceMapper;
    }

    @Override
    public List<MaintenanceDTO> getAllMaintenances() {
        List<MaintenanceModel> maintenances = maintenanceRepository.findAll();
        return maintenances.stream()
                .map(maintenanceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MaintenanceDTO getMaintenanceById(Long id) {
        MaintenanceModel maintenances = maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance not found with id: " + id));
        return maintenanceMapper.toDTO(maintenances);
    }

    @Override
    public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {
        if (maintenanceDTO.getParkingLot() == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }

        ParkingLotModel parkingLot = parkingLotRepository.findById(maintenanceDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        MaintenanceModel maintenance = new MaintenanceModel();
        maintenance.setParkingLot(parkingLot);
        maintenance.setDescription(maintenanceDTO.getDescription());
        maintenance.setScheduledDate(maintenanceDTO.getScheduledDate());
        maintenance.setCreatedAt(maintenanceDTO.getCreatedAt());
        maintenance.setUpdatedAt(maintenanceDTO.getUpdatedAt());

        MaintenanceModel savedMaintenance = maintenanceRepository.save(maintenance);
        return maintenanceMapper.toDTO(savedMaintenance);
    }

    @Override
    public MaintenanceDTO updateMaintenance(Long id, MaintenanceDTO maintenanceDTO) {
        MaintenanceModel existingMaintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance not found with id: " + id));


        if (maintenanceDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(maintenanceDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("Maintenance not found"));
            existingMaintenance.setParkingLot(parkingLot);
        }

        if(maintenanceDTO.getDescription()!=null){
            existingMaintenance.setDescription(maintenanceDTO.getDescription());
        }

        if(maintenanceDTO.getScheduledDate()!=null){
            existingMaintenance.setScheduledDate(maintenanceDTO.getScheduledDate());
        }

        if(maintenanceDTO.getCreatedAt()!=null){
            existingMaintenance.setCreatedAt(maintenanceDTO.getCreatedAt());
        }
        if(maintenanceDTO.getUpdatedAt()!=null){
            existingMaintenance.setUpdatedAt(maintenanceDTO.getUpdatedAt());
        }

        MaintenanceModel updatedMaintenance = maintenanceRepository.save(existingMaintenance);
        return maintenanceMapper.toDTO(updatedMaintenance);
    }

    @Override
    public void deleteMaintenance(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance not found with id: " + id);
        }
        maintenanceRepository.deleteById(id);
    }

}
