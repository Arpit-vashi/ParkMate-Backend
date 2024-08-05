package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.AlertDTO;
import org.arpitvashi.parkmate.Mapper.AlertMapper;
import org.arpitvashi.parkmate.Model.AlertModel;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Repository.AlertRepository;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    private final UserRepository userRepository;
    private final AlertMapper alertMapper;

    @Autowired
    public AlertServiceImpl(AlertRepository alertRepository, UserRepository userRepository, AlertMapper alertMapper) {
        this.alertRepository = alertRepository;
        this.userRepository = userRepository;
        this.alertMapper = alertMapper;
    }

    @Override
    public List<AlertDTO> getAllAlerts() {
        List<AlertModel> alerts = alertRepository.findAll();
        return alerts.stream()
                .map(alertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlertDTO getAlertById(Long id) {
        AlertModel alerts = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with id: " + id));
        return alertMapper.toDTO(alerts);
    }

    @Override
    public AlertDTO createAlert(AlertDTO alertDTO) {
        if (alertDTO.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        UserModel user = userRepository.findById(alertDTO.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        AlertModel alert = new AlertModel();
        alert.setMessage(alertDTO.getMessage());
        alert.setAlertTime(alertDTO.getAlertTime());
        alert.setUser(user);
        alert.setCreatedAt(alertDTO.getCreatedAt());
        alert.setUpdatedAt(alertDTO.getUpdatedAt());

        AlertModel savedAlert = alertRepository.save(alert);
        return alertMapper.toDTO(savedAlert);
    }

    @Override
    public AlertDTO updateAlert(Long id, AlertDTO alertDTO) {
        AlertModel existingAlert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with id: " + id));

        if(alertDTO.getMessage()!=null){
            existingAlert.setMessage(alertDTO.getMessage());
        }
        if(alertDTO.getAlertTime()!= null) {
            existingAlert.setAlertTime(alertDTO.getAlertTime());
        }

        if (alertDTO.getUser() != null) {
            UserModel user = userRepository.findById(alertDTO.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existingAlert.setUser(user);
        }
        if(alertDTO.getCreatedAt()!= null) {
            existingAlert.setCreatedAt(alertDTO.getCreatedAt());
        }
        if(alertDTO.getUpdatedAt()!= null) {
            existingAlert.setUpdatedAt(alertDTO.getUpdatedAt());
        }

        AlertModel updatedAlert = alertRepository.save(existingAlert);
        return alertMapper.toDTO(updatedAlert);
    }

    @Override
    public void deleteAlert(Long id) {
        if (!alertRepository.existsById(id)) {
            throw new RuntimeException("Alert not found with id: " + id);
        }
        alertRepository.deleteById(id);
    }

}
