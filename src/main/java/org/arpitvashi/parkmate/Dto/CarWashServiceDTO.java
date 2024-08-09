package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.BookingModel;

import java.math.BigDecimal;
import java.util.Date;

public class CarWashServiceDTO {

    private Long carWashId;

    private String serviceType;

    private BigDecimal serviceCost;

    private BookingModel booking;

    private Date createdAt;

    private Date updatedAt;

    public CarWashServiceDTO() {

    }

    public CarWashServiceDTO(Long carWashId, String serviceType, BigDecimal serviceCost, BookingModel booking, Date createdAt, Date updatedAt) {
        this.carWashId = carWashId;
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

}
