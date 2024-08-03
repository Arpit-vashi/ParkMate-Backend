package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;

import java.util.Date;

public class MaintenanceDTO {

    private Long maintenanceId;

    private ParkingLotModel parkingLot;

    private String description;

    private Date scheduledDate;

    private Date createdAt;

    private Date updatedAt;

    public MaintenanceDTO() {

    }

    public MaintenanceDTO(Long maintenanceId, ParkingLotModel parkingLot, String description, Date scheduledDate, Date createdAt, Date updatedAt) {
        this.maintenanceId = maintenanceId;
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

}
