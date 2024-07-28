package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.arpitvashi.parkmate.Model.VehicleModel;

import java.util.Date;

public class ParkingHistoryDTO {

    private Long parkingHistoryId;

    private Date entryTime;

    private Date exitTime;

    private VehicleModel vehicle;

    private ParkingSpaceModel parkingSpace;

    private Date createdAt;

    private Date updatedAt;

    public ParkingHistoryDTO() {

    }

    public ParkingHistoryDTO(Long parkingHistoryId, Date entryTime, Date exitTime, VehicleModel vehicle, ParkingSpaceModel parkingSpace, Date createdAt, Date updatedAt) {
        this.parkingHistoryId = parkingHistoryId;
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

}
