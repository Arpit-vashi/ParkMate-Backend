package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.AlertDTO;

import java.util.List;

public interface AlertService {

    AlertDTO createAlert(AlertDTO alert);

    List<AlertDTO> getAllAlerts();

    AlertDTO getAlertById(Long id);

    AlertDTO updateAlert(Long id, AlertDTO alertDTO);

    void deleteAlert(Long id);

}
