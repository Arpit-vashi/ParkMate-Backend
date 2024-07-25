package org.arpitvashi.parkmate.Dto;

import java.util.Date;

public class VehicleTypesDTO {

    private Long vehicletypeId;

    private String typename;

    private Date createdAt;

    private Date updatedAt;

    public VehicleTypesDTO() {

    }

    public VehicleTypesDTO(Long vehicletypeId, String typename, Date createdAt, Date updatedAt) {
        this.vehicletypeId = vehicletypeId;
        this.typename = typename;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getVehicletypeId() { return vehicletypeId; }

    public void setVehicletypeId(Long vehicletypeId) { this.vehicletypeId = vehicletypeId; }

    public String getTypename() { return typename; }

    public void setTypename(String typename) { this.typename = typename; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

}
