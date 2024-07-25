package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.VehicleTypesModel;

import java.util.Date;

public class VehicleDTO {

    private Long vehicleId;

    private String licensePlate;

    private Boolean isElectric;

    private VehicleTypesModel vehicleType;

    private UserModel user;

    private Date createdAt;

    private Date updatedAt;

    public VehicleDTO() {}

    public VehicleDTO(Long vehicleId, String licensePlate, Boolean isElectric, VehicleTypesModel vehicleType, UserModel user, Date createdAt, Date updatedAt) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.isElectric = isElectric;
        this.vehicleType = vehicleType;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getIsElectric() {
        return isElectric;
    }

    public void setIsElectric(Boolean isElectric) {
        this.isElectric = isElectric;
    }

    public VehicleTypesModel getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypesModel vehicleType) {
        this.vehicleType = vehicleType;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
