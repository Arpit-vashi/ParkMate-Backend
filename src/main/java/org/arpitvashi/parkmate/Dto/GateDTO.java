package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;

import java.util.Date;

public class GateDTO {

    private Long gateId;

    private String gateType;

    private ParkingLotModel parkingLot;

    private Date createdAt;

    private Date updatedAt;

    public GateDTO() {

    }
    public GateDTO(Long gateId, String gateType, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.gateId = gateId;
        this.gateType = gateType;
        this.parkingLot = parkingLot;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getGateType() {
        return gateType;
    }

    public void setGateType(String gateType) {
        this.gateType = gateType;
    }

    public ParkingLotModel getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotModel parkingLot) {
        this.parkingLot = parkingLot;
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
