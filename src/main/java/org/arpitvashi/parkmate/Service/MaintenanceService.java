package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.MaintenanceDTO;
import java.util.List;

public interface MaintenanceService {

    MaintenanceDTO createMaintenance(MaintenanceDTO maintenance);

    List<MaintenanceDTO> getAllMaintenances();

    MaintenanceDTO getMaintenanceById(Long id);

    MaintenanceDTO updateMaintenance(Long id, MaintenanceDTO maintenanceDTO);

    void deleteMaintenance(Long id);

}
