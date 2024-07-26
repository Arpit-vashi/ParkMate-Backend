package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.FloorModel;
import org.arpitvashi.parkmate.Model.ParkingLotModel;

import java.math.BigInteger;
import java.util.Date;

public class ParkingSpaceDTO {

    private Long parkingSpaceId;

    private BigInteger spaceNumber;

    private Boolean isOccupied;

    private Boolean isEVCharging;

    private FloorModel floor;

    private Date createdAt;

    private Date updatedAt;

    public ParkingSpaceDTO() {

    }

    public ParkingSpaceDTO(Long parkingSpaceId, BigInteger spaceNumber, Boolean isOccupied, Boolean isEVCharging, FloorModel floor, Date createdAt, Date updatedAt) {
        this.parkingSpaceId = parkingSpaceId;
        this.spaceNumber = spaceNumber;
        this.isOccupied = isOccupied;
        this.isEVCharging = isEVCharging;
        this.floor = floor;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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



}
