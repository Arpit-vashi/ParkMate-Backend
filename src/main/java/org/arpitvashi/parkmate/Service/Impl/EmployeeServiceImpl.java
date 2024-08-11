package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.EmployeeDTO;
import org.arpitvashi.parkmate.Mapper.EmployeeMapper;
import org.arpitvashi.parkmate.Model.EmployeeModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Repository.EmployeeRepository;
import org.arpitvashi.parkmate.Repository.ParkingLotRepository;
import org.arpitvashi.parkmate.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    private final ParkingLotRepository parkingLotRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ParkingLotRepository parkingLotRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeModel> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeModel employees = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return employeeMapper.toDTO(employees);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getParkingLot() == null) {
            throw new IllegalArgumentException("ParkingLot cannot be null");
        }

        ParkingLotModel parlingLot = parkingLotRepository.findById(employeeDTO.getParkingLot().getParkingLotId())
                .orElseThrow(() -> new RuntimeException("ParkingLot not found"));

        EmployeeModel employee = new EmployeeModel();
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());
        employee.setName(employeeDTO.getName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setMobileNo(employeeDTO.getMobileNo());
        employee.setEmail(employeeDTO.getEmail());
        employee.setRole(employeeDTO.getRole());
        employee.setDuty(employeeDTO.getDuty());
        employee.setSalary(employeeDTO.getSalary());
        employee.setParkingLot(parlingLot);
        employee.setCreatedAt(new Date());
        employee.setUpdatedAt(new Date());

        EmployeeModel savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        EmployeeModel existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if(employeeDTO.getUsername()!=null){
            existingEmployee.setUsername(employeeDTO.getUsername());
        }
        if(employeeDTO.getPassword()!= null) {
            existingEmployee.setPassword(employeeDTO.getPassword());
        }
        if(employeeDTO.getName()!= null) {
            existingEmployee.setName(employeeDTO.getName());
        }
        if(employeeDTO.getAddress()!= null) {
            existingEmployee.setAddress(employeeDTO.getAddress());
        }
        if(employeeDTO.getMobileNo()!= null) {
            existingEmployee.setMobileNo(employeeDTO.getMobileNo());
        }
        if(employeeDTO.getEmail()!= null) {
            existingEmployee.setEmail(employeeDTO.getEmail());
        }
        if(employeeDTO.getRole()!= null) {
            existingEmployee.setRole(employeeDTO.getRole());
        }
        if(employeeDTO.getDuty()!= null) {
            existingEmployee.setDuty(employeeDTO.getDuty());
        }
        if(employeeDTO.getSalary()!= null) {
            existingEmployee.setSalary(employeeDTO.getSalary());
        }
        if (employeeDTO.getParkingLot() != null) {
            ParkingLotModel parkingLot = parkingLotRepository.findById(employeeDTO.getParkingLot().getParkingLotId())
                    .orElseThrow(() -> new RuntimeException("ParkingLot not found"));
            existingEmployee.setParkingLot(parkingLot);
        }
        if(employeeDTO.getCreatedAt()!=null){
            existingEmployee.setCreatedAt(employeeDTO.getCreatedAt());
        }
        if(employeeDTO.getUpdatedAt()!=null){
            existingEmployee.setUpdatedAt(employeeDTO.getUpdatedAt());
        }

        existingEmployee.setUpdatedAt(new Date());
        EmployeeModel updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

}
