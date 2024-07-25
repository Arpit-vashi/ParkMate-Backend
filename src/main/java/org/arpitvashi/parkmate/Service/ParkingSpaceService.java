package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.FloorDTO;
import org.arpitvashi.parkmate.Dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingSpaceService {

    ParkingSpaceDTO createParkingSpace(ParkingSpaceDTO parkingSpace);

   List<ParkingSpaceDTO> getAllParkingSpaces();

  ParkingSpaceDTO getParkingSpaceById(Long id);

  ParkingSpaceDTO updateParkingSpace(Long id, ParkingSpaceDTO parkingSpaceDetails);

    void deleteParkingSpace(Long id);

}
