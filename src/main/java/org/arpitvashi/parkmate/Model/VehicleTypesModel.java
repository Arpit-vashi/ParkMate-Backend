package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "VehicleTypes")
public class VehicleTypesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicletype_id")
    private Long vehicletypeId;

    @Column(name = "typename")
    private String typename;

    public VehicleTypesModel() {

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


}
