package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDTO {

    private Long employeeId;

    private String username;

    private String password;

    private String name;

    private String address;

    private Long mobileNo;

    private String email;

    private String role;

    private String duty;

    private BigDecimal salary;

    private ParkingLotModel parkingLot;

    private Date createdAt;

    private Date updatedAt;

    public EmployeeDTO() {

    }

    public EmployeeDTO(Long employeeId, String username, String password, String name, String address, Long mobileNo,
                       String email, String role, String duty, BigDecimal salary, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        this.email = email;
        this.role = role;
        this.duty = duty;
        this.salary = salary;
        this.parkingLot = parkingLot;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getEmployeeId() { return employeeId; }

    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Long getMobileNo() { return mobileNo; }

    public void setMobileNo(Long mobileNo) { this.mobileNo = mobileNo; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getDuty() { return duty; }

    public void setDuty(String duty) { this.duty = duty; }

    public BigDecimal getSalary() { return salary; }

    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public ParkingLotModel getParkingLot() { return parkingLot; }

    public void setParkingLot(ParkingLotModel parkingLot) { this.parkingLot = parkingLot; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

}
