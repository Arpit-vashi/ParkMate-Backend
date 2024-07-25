package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ParkingSpaces")
public class ParkingSpaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParkingSpaceID")
    private Long parkingSpaceId;

    @Column(name = "SpaceNumber", nullable = false)
    private BigInteger spaceNumber;

    @Column(name = "IsOccupied")
    private Boolean isOccupied = false;

    @Column(name = "IsEVCharging")
    private Boolean isEVCharging = false;

    @ManyToOne
    @JoinColumn(name = "FloorID", nullable = false)
    private FloorModel floor;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Default constructor
    public ParkingSpaceModel() {}

    // Parameterized constructor
    public ParkingSpaceModel(BigInteger spaceNumber, Boolean isOccupied, Boolean isEVCharging, FloorModel floor, Date createdAt, Date updatedAt) {
        this.spaceNumber = spaceNumber;
        this.isOccupied = isOccupied;
        this.isEVCharging = isEVCharging;
        this.floor = floor;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public Long getParkingSpaceId() { return parkingSpaceId; }

    public void setParkingSpaceId(Long parkingSpaceId) { this.parkingSpaceId = parkingSpaceId; }

    public BigInteger getSpaceNumber() { return spaceNumber; }

    public void setSpaceNumber(BigInteger spaceNumber) { this.spaceNumber = spaceNumber; }

    public Boolean getIsOccupied() { return isOccupied; }

    public void setIsOccupied(Boolean isOccupied) { this.isOccupied = isOccupied; }

    public Boolean getIsEVCharging() { return isEVCharging; }

    public void setIsEVCharging(Boolean isEVCharging) { this.isEVCharging = isEVCharging; }

    public FloorModel getFloor() { return floor; }

    public void setFloor(FloorModel floor) { this.floor = floor; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    // Automatically set createdAt and updatedAt before persisting or updating the entity
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
