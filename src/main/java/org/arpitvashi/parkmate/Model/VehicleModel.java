package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehicles")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "isElectric", nullable = false)
    private Boolean isElectric;

    @ManyToOne
    @JoinColumn(name = "vehicletype_id", nullable = false)
    private VehicleTypesModel vehicleType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public VehicleModel() {}

    public VehicleModel(String licensePlate, Boolean isElectric, VehicleTypesModel vehicleType, UserModel user) {
        this.licensePlate = licensePlate;
        this.isElectric = isElectric;
        this.vehicleType = vehicleType;
        this.user = user;
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

    public Boolean getIsElectric() { return isElectric; }

    public void setIsElectric(Boolean isElectric) { this.isElectric = isElectric; }

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
}
