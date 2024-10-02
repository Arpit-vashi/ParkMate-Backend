package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ParkingLotDTO;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ParkingLotService {

    ParkingLotDTO createParkingLot(ParkingLotDTO parkingLot);

    Page<ParkingLotDTO> getAllParkingLots(int page, int size);

    ParkingLotDTO getParkingLotById(Long id);

    ParkingLotDTO updateParkingLot(Long id, ParkingLotDTO parkingLotDetails);

    void deleteParkingLot(Long id);

    List<ParkingLotDTO> searchParkingLots(String search, Pageable pageable);
}
