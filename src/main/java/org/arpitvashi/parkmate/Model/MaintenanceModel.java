package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Maintenance")
public class MaintenanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaintenanceID")
    private Long maintenanceId;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "ScheduledDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledDate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public MaintenanceModel() {
    }

    public MaintenanceModel(ParkingLotModel parkingLot, String description, Date scheduledDate, Date createdAt, Date updatedAt) {
        this.parkingLot = parkingLot;
        this.description = description;
        this.scheduledDate = scheduledDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public ParkingLotModel getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotModel parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
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
