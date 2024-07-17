package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.UserDTO;
import org.arpitvashi.parkmate.Dto.VehicleTypesDTO;
import org.arpitvashi.parkmate.Mapper.UserMapper;
import org.arpitvashi.parkmate.Mapper.VehicleTypesMapper;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.VehicleTypesModel;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Repository.VehicleTypesRepository;
import org.arpitvashi.parkmate.Service.VehicleTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleTypesServiceImpl implements VehicleTypesService {


    @Autowired
    private final VehicleTypesRepository vehicleTypesRepository;
    private final VehicleTypesMapper vehicleTypesMapper;

    @Autowired
    public VehicleTypesServiceImpl(VehicleTypesRepository vehicleTypesRepository, VehicleTypesMapper vehicleTypesMapper) {
        this.vehicleTypesRepository = vehicleTypesRepository;
        this.vehicleTypesMapper = vehicleTypesMapper;
    }

    @Override
    public List<VehicleTypesDTO> getAllVehicleTypes() {
        List<VehicleTypesModel> vehicleTypes = vehicleTypesRepository.findAll();
        return vehicleTypes.stream()
                .map(vehicleTypesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleTypesDTO createVehicleTypes(VehicleTypesDTO vehicleTypesDTO) {
        VehicleTypesModel vehicleTypes = vehicleTypesMapper.toEntity(vehicleTypesDTO);
        VehicleTypesModel savedvehicleTypes = vehicleTypesRepository.save(vehicleTypes);
        return vehicleTypesMapper.toDTO(savedvehicleTypes);
    }

}
