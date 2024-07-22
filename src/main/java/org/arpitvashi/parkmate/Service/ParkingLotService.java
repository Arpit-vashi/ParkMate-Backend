package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ParkingLotDTO;

import java.util.List;

public interface ParkingLotService {

    ParkingLotDTO createParkingLot(ParkingLotDTO parkingLot);

    List<ParkingLotDTO> getAllParkingLots();

    ParkingLotDTO getParkingLotById(Long id);

    ParkingLotDTO updateParkingLot(Long id, ParkingLotDTO parkingLotDetails);

    void deleteParkingLot(Long id);

}
