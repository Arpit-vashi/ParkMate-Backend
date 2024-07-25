package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "VehicleTypes")
public class VehicleTypesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicletype_id")
    private Long vehicletypeId;

    @Column(name = "typename")
    private String typename;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public VehicleTypesModel() {

    }

    public VehicleTypesModel(String typename, Date createdAt, Date updatedAt) {
        this.typename = typename;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public VehicleTypesModel(String typename) {
        this.typename = typename;
    }

    public Long getVehicletypeId() { return vehicletypeId; }

    public void setVehicletypeId(Long vehicletypeId) {
        this.vehicletypeId = vehicletypeId;
    }

    public String getTypename() { return typename; }

    public void setTypename(String typename) { this.typename = typename; }

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
