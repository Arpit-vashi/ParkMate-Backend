package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingSpaceModel;

import java.util.Date;

public class EVChargingStationDTO {

    private Long chargingStationId;

    private Boolean isOccupied;

    private ParkingSpaceModel parkingSpace;

    private Date createdAt;

    private Date updatedAt;

    public EVChargingStationDTO() {

    }

    public EVChargingStationDTO(Long chargingStationId, Boolean isOccupied, ParkingSpaceModel parkingSpace, Date createdAt, Date updatedAt) {
        this.chargingStationId = chargingStationId;
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

}
