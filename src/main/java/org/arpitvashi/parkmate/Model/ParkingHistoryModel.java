package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ParkingHistory")
public class ParkingHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoryID")
    private Long parkingHistoryId;

    @Column(name = "EntryTime", nullable = false)
    private Date entryTime;

    @Column(name = "ExitTime")
    private Date exitTime;

    @ManyToOne
    @JoinColumn(name = "VehicleID", nullable = false)
    private VehicleModel vehicle;

    @ManyToOne
    @JoinColumn(name = "ParkingSpaceID", nullable = false)
    private ParkingSpaceModel parkingSpace;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ParkingHistoryModel() {}

    public ParkingHistoryModel(Date entryTime, Date exitTime, VehicleModel vehicle, ParkingSpaceModel parkingSpace, Date createdAt, Date updatedAt) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getParkingHistoryId() {
        return parkingHistoryId;
    }

    public void setParkingHistoryId(Long parkingHistoryId) {
        this.parkingHistoryId = parkingHistoryId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpaceModel getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpaceModel parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

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
