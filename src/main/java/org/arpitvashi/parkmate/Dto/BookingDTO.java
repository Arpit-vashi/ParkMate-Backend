package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.arpitvashi.parkmate.Model.VehicleModel;

import java.time.LocalDateTime;
import java.util.Date;

public class BookingDTO {

    private Long bookingId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String bookingStatus;

    private ParkingLotModel parkingLot;

    private ParkingSpaceModel parkingSpace;

    private VehicleModel vehicle;

    private Date createdAt;

    private Date updatedAt;

    public BookingDTO() {

    }

    public BookingDTO(Long bookingId, LocalDateTime startTime, LocalDateTime endTime, String bookingStatus, ParkingLotModel parkingLot, ParkingSpaceModel parkingSpace, VehicleModel vehicle, Date createdAt, Date updatedAt) {
        this.bookingId = bookingId;
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

}
