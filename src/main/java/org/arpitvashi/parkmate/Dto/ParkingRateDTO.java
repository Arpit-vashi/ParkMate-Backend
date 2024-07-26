package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Model.VehicleTypesModel;

import java.util.Date;

public class ParkingRateDTO {

    private Long rateId;

    private Double rate;

    private ParkingLotModel parkingLot;

    private VehicleTypesModel vehicleType;

    private Date createdAt;

    private Date updatedAt;

    public ParkingRateDTO() {

    }
    public ParkingRateDTO(Long rateId, Double rate, ParkingLotModel parkingLot, VehicleTypesModel vehicleType, Date createdAt, Date updatedAt) {
        this.rateId = rateId;
        this.rate = rate;
        this.parkingLot = parkingLot;
        this.vehicleType = vehicleType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public ParkingLotModel getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotModel parkingLot) {
        this.parkingLot = parkingLot;
    }

    public VehicleTypesModel getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypesModel vehicleType) {
        this.vehicleType = vehicleType;
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
