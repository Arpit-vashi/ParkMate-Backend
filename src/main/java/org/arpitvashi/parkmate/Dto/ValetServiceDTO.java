package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.BookingModel;

import java.math.BigDecimal;
import java.util.Date;

public class ValetServiceDTO {

    private Long valetId;

    private BigDecimal valetCharge;

    private BookingModel booking;

    private Date createdAt;

    private Date updatedAt;

    public ValetServiceDTO() {

    }

    public ValetServiceDTO(Long valetId, BigDecimal valetCharge, BookingModel booking, Date createdAt, Date updatedAt) {
        this.valetId = valetId;
        this.valetCharge = valetCharge;
        this.booking = booking;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getValetId() {
        return valetId;
    }

    public void setValetId(Long valetId) {
        this.valetId = valetId;
    }

    public BigDecimal getValetCharge() {
        return valetCharge;
    }

    public void setValetCharge(BigDecimal valetCharge) {
        this.valetCharge = valetCharge;
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
