package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ParkingRateDTO;

import java.util.List;

public interface ParkingRateService {

    ParkingRateDTO createParkingRate(ParkingRateDTO parkingRateDTO);

    List<ParkingRateDTO> getAllParkingRates();

    ParkingRateDTO getParkingRateById(Long id);

   ParkingRateDTO updateParkingRate(Long id, ParkingRateDTO parkingRateDTO);

    void deleteParkingRate(Long id);

}
