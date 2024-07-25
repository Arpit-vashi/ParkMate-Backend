package org.arpitvashi.parkmate.Dto;

import java.math.BigInteger;
import java.util.Date;

public class ParkingLotDTO {

    private Long parkingLotId;

    private String name;

    private String location;

    private BigInteger capacity;

    private Date createdAt;

    private Date updatedAt;

    public ParkingLotDTO() {

    }

    public ParkingLotDTO(Long parkingLotId, String name, String location, BigInteger capacity, Date createdAt, Date updatedAt) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getParkingLotId() { return parkingLotId; }

    public void setParkingLotId(Long parkingLotId) { this.parkingLotId = parkingLotId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public BigInteger getCapacity() { return capacity; }

    public void setCapacity(BigInteger capacity) { this.capacity = capacity; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }



}
