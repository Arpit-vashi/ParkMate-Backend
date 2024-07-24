package org.arpitvashi.parkmate.Dto;

import java.math.BigInteger;

public class ParkingLotDTO {

    private Long parkingLotId;

    private String name;

    private String location;

    private BigInteger capacity;

    public ParkingLotDTO() {

    }

    public ParkingLotDTO(Long parkingLotId, String name, String location, BigInteger capacity) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getParkingLotId() { return parkingLotId; }

    public void setParkingLotId(Long parkingLotId) { this.parkingLotId = parkingLotId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public BigInteger getCapacity() { return capacity; }

    public void setCapacity(BigInteger capacity) { this.capacity = capacity; }


}
