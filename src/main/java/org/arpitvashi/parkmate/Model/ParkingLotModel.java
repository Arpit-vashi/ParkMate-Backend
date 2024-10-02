package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "parking_lots",
        indexes = {
                @Index(name = "idx_name", columnList = "name"),
                @Index(name = "idx_city", columnList = "city"),
                @Index(name = "idx_state", columnList = "state"),
                @Index(name = "idx_createdAt", columnList = "createdAt"),
                @Index(name = "idx_capacity", columnList = "capacity")
        })
public class ParkingLotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParkingLotID")
    private Long parkingLotId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "AddressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "CountryID", nullable = false)
    private CountryModel country;

    @Column(name = "SupportEmail", nullable = true)
    private String supportEmail;

    @Column(name = "SupportMobile", nullable = true)
    private String supportMobile;

    @Column(name = "Capacity", nullable = false)
    private BigInteger capacity;

    @Column(name = "Floors", nullable = false)
    private BigInteger floors;

    @Column(name = "UsedFloors", nullable = false)
    private BigInteger usedFloors;

    @ManyToMany
    @JoinTable(
            name = "ParkingLot_Owners",
            joinColumns = @JoinColumn(name = "ParkingLotID"),
            inverseJoinColumns = @JoinColumn(name = "EmployeeID")
    )
    private List<EmployeeModel> owners;  // Parking lot can have multiple owners

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ParkingLotModel() {}

    public ParkingLotModel(String name, String location, String addressLine1, String city, String state, CountryModel country,
                           String supportEmail, String supportMobile, BigInteger capacity, BigInteger floors, BigInteger usedFloors,
                           List<EmployeeModel> owners, Date createdAt, Date updatedAt) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.country = country;
        this.supportEmail = supportEmail;
        this.supportMobile = supportMobile;
        this.capacity = capacity;
        this.floors = floors;
        this.usedFloors = usedFloors;
        this.owners = owners;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {
        this.country = country;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public String getSupportMobile() {
        return supportMobile;
    }

    public void setSupportMobile(String supportMobile) {
        this.supportMobile = supportMobile;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public BigInteger getFloors() {
        return floors;
    }

    public void setFloors(BigInteger floors) {
        this.floors = floors;
    }

    public BigInteger getUsedFloors() {
        return usedFloors;
    }

    public void setUsedFloors(BigInteger usedFloors) {
        this.usedFloors = usedFloors;
    }

    public List<EmployeeModel> getOwners() {
        return owners;
    }

    public void setOwners(List<EmployeeModel> owners) {
        this.owners = owners;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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
