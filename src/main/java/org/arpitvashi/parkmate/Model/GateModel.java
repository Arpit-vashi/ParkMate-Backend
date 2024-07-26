package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Gates")
public class GateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GateID")
    private Long gateId;

    @Column(name = "GateType", nullable = false)
    private String gateType; // Entry or Exit

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public GateModel() {
    }

    public GateModel(String gateType, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
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
