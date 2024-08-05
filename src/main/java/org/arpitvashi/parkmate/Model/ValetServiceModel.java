package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ValetService")
public class ValetServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ValetID")
    private Long valetId;

    @Column(name = "ValetCharge", nullable = false)
    private BigDecimal valetCharge;

    @ManyToOne
    @JoinColumn(name = "BookingID", nullable = false)
    private BookingModel booking;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ValetServiceModel() {}

    public ValetServiceModel(BigDecimal valetCharge, BookingModel booking, Date createdAt, Date updatedAt) {
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
