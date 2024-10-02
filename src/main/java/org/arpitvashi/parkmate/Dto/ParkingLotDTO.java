package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.EmployeeModel;
import org.arpitvashi.parkmate.Model.CountryModel;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ParkingLotDTO {

    private Long parkingLotId;
    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private CountryModel country;
    private String supportEmail;
    private String supportMobile;  // Format: +(country code)-(number)
    private BigInteger capacity;
    private BigInteger floors;
    private BigInteger usedFloors;
    private List<EmployeeModel> owners;  // List of employees linked as owners
    private Date createdAt;
    private Date updatedAt;

    public ParkingLotDTO() {}

    public ParkingLotDTO(Long parkingLotId, String name, String addressLine1, String city, String state,
                         CountryModel country, String supportEmail, String supportMobile, BigInteger capacity,
                         BigInteger floors, BigInteger usedFloors, List<EmployeeModel> owners, Date createdAt, Date updatedAt) {
        this.parkingLotId = parkingLotId;
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
}
