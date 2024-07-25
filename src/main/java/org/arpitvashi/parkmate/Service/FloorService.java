package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.VehicleDTO;

import java.util.List;

public interface FloorService {

    FloorDTO createFloor(FloorDTO floor);

    List<FloorDTO> getAllFloors();

   FloorDTO getFloorById(Long id);

   FloorDTO updateFloor(Long id, FloorDTO floorDetails);

  void deleteFloor(Long id);

}
