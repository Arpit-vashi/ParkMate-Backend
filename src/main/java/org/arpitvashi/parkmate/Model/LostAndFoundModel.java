package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LostAndFound")
public class LostAndFoundModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Long itemId;

    @Column(name = "Description", nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FoundAt", nullable = false)
    private Date foundAt;

    @Column(name = "Claimed", nullable = false)
    private Boolean claimed = false;

    @ManyToOne
    @JoinColumn(name = "ParkingLotID", referencedColumnName = "ParkingLotID")
    private ParkingLotModel parkingLot;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public LostAndFoundModel() {
    }

    public LostAndFoundModel(String description, Date foundAt, Boolean claimed, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.description = description;
        this.foundAt = foundAt;
        this.claimed = claimed;
        this.parkingLot = parkingLot;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(Date foundAt) {
        this.foundAt = foundAt;
    }

    public Boolean getClaimed() {
        return claimed;
    }

    public void setClaimed(Boolean claimed) {
        this.claimed = claimed;
    }

    public ParkingLotModel getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotModel parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        if (this.foundAt == null) {
            this.foundAt = new Date();
        }
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
