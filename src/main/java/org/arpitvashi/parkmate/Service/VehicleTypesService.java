package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.VehicleTypesDTO;

import java.util.List;

public interface VehicleTypesService {

    VehicleTypesDTO createVehicleTypes(VehicleTypesDTO vehicleTypesDTO);

    List<VehicleTypesDTO> getAllVehicleTypes();

    VehicleTypesDTO getVehicleTypesById(Long id);

    VehicleTypesDTO updateVehicleTypes(Long id, VehicleTypesDTO vehicleTypesDTO);

    void deleteVehicleTypes(Long id);


}
