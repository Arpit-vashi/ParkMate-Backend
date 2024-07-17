package org.arpitvashi.parkmate.Dto;

public class VehicleTypesDTO {

    private Long vehicletypeId;

    private String typename;

    public VehicleTypesDTO() {

    }

    public VehicleTypesDTO(Long vehicletypeId, String typename) {
        this.vehicletypeId = vehicletypeId;
        this.typename = typename;
    }

    public Long getVehicletypeId() { return vehicletypeId; }

    public void setVehicletypeId(Long vehicletypeId) { this.vehicletypeId = vehicletypeId; }

    public String getTypename() { return typename; }

    public void setTypename(String typename) { this.typename = typename; }

}
