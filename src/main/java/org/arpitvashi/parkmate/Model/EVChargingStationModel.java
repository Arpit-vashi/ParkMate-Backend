package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVChargingStations")
public class EVChargingStationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChargingStationID")
    private Long chargingStationId;

    @Column(name = "IsOccupied", nullable = false)
    private Boolean isOccupied = false;

    @OneToOne
    @JoinColumn(name = "ParkingSpaceID", referencedColumnName = "ParkingSpaceID", nullable = false)
    private ParkingSpaceModel parkingSpace;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    public EVChargingStationModel() {

    }

    public EVChargingStationModel(Boolean isOccupied, ParkingSpaceModel parkingSpace, Date createdAt, Date updatedAt) {
        this.isOccupied = isOccupied;
        this.parkingSpace = parkingSpace;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Long chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public ParkingSpaceModel getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpaceModel parkingSpace) {
        this.parkingSpace = parkingSpace;
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
