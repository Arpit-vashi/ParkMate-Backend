package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CarWashServices")
public class CarWashServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CarWashID")
    private Long carWashId;

    @Column(name = "ServiceType", nullable = false)
    private String serviceType;

    @Column(name = "ServiceCost", nullable = false)
    private BigDecimal serviceCost;

    @ManyToOne
    @JoinColumn(name = "BookingID", nullable = false)
    private BookingModel booking;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public CarWashServiceModel() {}

    public CarWashServiceModel(String serviceType, BigDecimal serviceCost, BookingModel booking, Date createdAt, Date updatedAt) {
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.booking = booking;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getCarWashId() {
        return carWashId;
    }

    public void setCarWashId(Long carWashId) {
        this.carWashId = carWashId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
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
