package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "Floors")
public class FloorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FloorID")
    private Long floorId;

    @Column(name = "FloorNumber", nullable = false)
    private BigInteger floorNumber;

    @Column(name = "Description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public FloorModel() {

    }

    public FloorModel(BigInteger floorNumber, String description, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.floorNumber = floorNumber;
        this.description = description;
        this.parkingLot = parkingLot;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getFloorId() { return floorId; }

    public void setFloorId(Long floorId) { this.floorId = floorId; }

    public BigInteger getFloorNumber() { return floorNumber; }

    public void setFloorNumber(BigInteger floorNumber) { this.floorNumber = floorNumber; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public ParkingLotModel getParkingLot() { return parkingLot; }

    public void setParkingLot(ParkingLotModel parkingLot) { this.parkingLot = parkingLot; }

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
