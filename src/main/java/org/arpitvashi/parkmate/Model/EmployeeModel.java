package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long employeeId;

    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "mobileno", nullable = false, unique = true)
    private Long mobileNo;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "Duty")
    private String duty;

    @Column(name = "Salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public EmployeeModel() {}

    public EmployeeModel(String username, String password, String name, String address, Long mobileNo,
                         String email, String role, String duty, BigDecimal salary, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
