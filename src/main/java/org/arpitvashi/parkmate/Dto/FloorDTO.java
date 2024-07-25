package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;

import javax.xml.crypto.Data;
import java.math.BigInteger;
import java.util.Date;

public class FloorDTO {

    private Long floorId;

    private BigInteger floorNumber;

    private String description;

    private ParkingLotModel parkingLot;

    private Date createdAt;

    private Date updatedAt;

    public FloorDTO() {

    }

    public FloorDTO(Long floorId, BigInteger floorNumber, String description, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.floorId = floorId;
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


}
