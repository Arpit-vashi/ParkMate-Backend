package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO createVehicle(VehicleDTO vehicle);

    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleById(Long id);

    VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDetails);

    void deleteVehicle(Long id);
}
