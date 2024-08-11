package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.EmployeeDTO;
import org.arpitvashi.parkmate.Model.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(EmployeeModel model) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(model.getEmployeeId());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setName(model.getName());
        dto.setAddress(model.getAddress());
        dto.setMobileNo(model.getMobileNo());
        dto.setEmail(model.getEmail());
        dto.setRole(model.getRole());
        dto.setDuty(model.getDuty());
        dto.setSalary(model.getSalary());
        dto.setParkingLot(model.getParkingLot());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static EmployeeModel toEntity(EmployeeDTO dto) {
        EmployeeModel model = new EmployeeModel();
        model.setEmployeeId(dto.getEmployeeId());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setMobileNo(dto.getMobileNo());
        model.setEmail(dto.getEmail());
        model.setRole(dto.getRole());
        model.setDuty(dto.getDuty());
        model.setSalary(dto.getSalary());
        model.setParkingLot(dto.getParkingLot());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
