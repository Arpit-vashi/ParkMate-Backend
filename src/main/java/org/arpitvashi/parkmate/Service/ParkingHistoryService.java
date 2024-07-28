package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ParkingHistoryDTO;

import java.util.List;

public interface ParkingHistoryService {

    ParkingHistoryDTO createParkingHistory(ParkingHistoryDTO parkingHistory);

    List<ParkingHistoryDTO> getAllParkingHistories();

    ParkingHistoryDTO getParkingHistoryById(Long id);

    ParkingHistoryDTO updateParkingHistory(Long id, ParkingHistoryDTO parkingHistoryDTO);

    void deleteParkingHistory(Long id);

}
