package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Bookings")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID")
    private Long bookingId;

    @Column(name = "StartTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "EndTime", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "BookingStatus", nullable = false)
    private String bookingStatus;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", nullable = false)
    private ParkingLotModel parkingLot;

    @ManyToOne
    @JoinColumn(name = "ParkingSpaceID", nullable = false)
    private ParkingSpaceModel parkingSpace;

    @ManyToOne
    @JoinColumn(name = "VehicleID", nullable = false)
    private VehicleModel vehicle;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public BookingModel() {}

    public BookingModel(LocalDateTime startTime, LocalDateTime endTime, String bookingStatus, ParkingLotModel parkingLot, ParkingSpaceModel parkingSpace, VehicleModel vehicle, Date createdAt, Date updatedAt) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingStatus = bookingStatus;
        this.parkingLot = parkingLot;
        this.parkingSpace = parkingSpace;
        this.vehicle = vehicle;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public ParkingLotModel getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotModel parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpaceModel getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpaceModel parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

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
