package org.arpitvashi.parkmate.Service.Impl;


import org.arpitvashi.parkmate.Dto.VehicleDTO;
import org.arpitvashi.parkmate.Mapper.VehicleMapper;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.VehicleModel;
import org.arpitvashi.parkmate.Model.VehicleTypesModel;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Repository.VehicleRepository;
import org.arpitvashi.parkmate.Repository.VehicleTypesRepository;
import org.arpitvashi.parkmate.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private final VehicleRepository vehicleRepository;

    private final VehicleTypesRepository vehicleTypesRepository;

    private final UserRepository userRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository, VehicleTypesRepository vehicleTypesRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypesRepository = vehicleTypesRepository;
        this.userRepository = userRepository;
        this.vehicleMapper = vehicleMapper;
    }


    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        VehicleModel vehicles = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        return vehicleMapper.toDTO(vehicles);
    }


    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getUser() == null || vehicleDTO.getVehicleType() == null) {
            throw new IllegalArgumentException("User or VehicleType cannot be null");
        }

        UserModel user = userRepository.findById(vehicleDTO.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        VehicleTypesModel vehicleType = vehicleTypesRepository.findById(vehicleDTO.getVehicleType().getVehicletypeId())
                .orElseThrow(() -> new RuntimeException("Vehicle type not found"));

        VehicleModel vehicle = new VehicleModel();
        vehicle.setLicensePlate(vehicleDTO.getLicensePlate());
        vehicle.setIsElectric(vehicleDTO.getIsElectric());
        vehicle.setVehicleType(vehicleType);
        vehicle.setUser(user);
        vehicle.setCreatedAt(vehicleDTO.getCreatedAt());
        vehicle.setUpdatedAt(vehicleDTO.getUpdatedAt());
        VehicleModel savedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toDTO(savedVehicle);
    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO) {
        VehicleModel existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

        if(vehicleDTO.getLicensePlate()!=null){
            existingVehicle.setLicensePlate(vehicleDTO.getLicensePlate());
        }
        if(vehicleDTO.getIsElectric()!= null) {
            existingVehicle.setIsElectric(vehicleDTO.getIsElectric());
        }

        if (vehicleDTO.getVehicleType() != null) {
            VehicleTypesModel vehicleType = vehicleTypesRepository.findById(vehicleDTO.getVehicleType().getVehicletypeId())
                    .orElseThrow(() -> new RuntimeException("VehicleType not found"));
            existingVehicle.setVehicleType(vehicleType);
        }

        if (vehicleDTO.getUser() != null) {
            UserModel user = userRepository.findById(vehicleDTO.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existingVehicle.setUser(user);
        }
        if(vehicleDTO.getCreatedAt()!= null) {
            existingVehicle.setCreatedAt(vehicleDTO.getCreatedAt());
        }
        if(vehicleDTO.getUpdatedAt()!= null) {
            existingVehicle.setUpdatedAt(vehicleDTO.getUpdatedAt());
        }

        VehicleModel updatedVehicle = vehicleRepository.save(existingVehicle);
        return vehicleMapper.toDTO(updatedVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }
        vehicleRepository.deleteById(id);
    }

}
