package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ParkingRates")
public class ParkingRateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RateID")
    private Long rateId;

    @Column(name = "Rate", nullable = false)
    private Double rate;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @ManyToOne
    @JoinColumn(name = "VehicleTypeID", nullable = false)
    private VehicleTypesModel vehicleType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ParkingRateModel() {}

    public ParkingRateModel(Double rate, ParkingLotModel parkingLot, VehicleTypesModel vehicleType, Date createdAt, Date updatedAt) {
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

    // Automatically set createdAt and updatedAt before persisting or updating the entity
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
