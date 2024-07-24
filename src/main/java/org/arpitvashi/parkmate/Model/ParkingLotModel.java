package org.arpitvashi.parkmate.Model;


import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "ParkingLots")
public class ParkingLotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParkingLotID")
    private Long parkingLotId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Location", nullable = false)
    private String location;

    @Column(name = "Capacity", nullable = false)
    private BigInteger capacity;

    public ParkingLotModel() {

    }

    public ParkingLotModel(String name, String location, BigInteger capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getParkingLotId() { return parkingLotId; }

    public void setParkingLotId(Long parkingLotId) { this.parkingLotId = parkingLotId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void  setLocation(String location) { this.location = location; }

    public BigInteger getCapacity() { return  capacity; }

    public void setCapacity(BigInteger capacity) { this.capacity = capacity; }

}
