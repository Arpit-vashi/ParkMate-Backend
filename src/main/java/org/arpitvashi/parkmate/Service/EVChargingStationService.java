package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.EVChargingStationDTO;
import java.util.List;

public interface EVChargingStationService {

    EVChargingStationDTO createEVChargingStation(EVChargingStationDTO evChargingStationDTO);

    List<EVChargingStationDTO> getAllEVChargingStations();

    EVChargingStationDTO getEVChargingStationById(Long id);

    EVChargingStationDTO updateEVChargingStation(Long id, EVChargingStationDTO evChargingStationDTO);

    void deleteEVChargingStation(Long id);

}
