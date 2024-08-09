package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.ParkingLotModel;

import java.util.Date;

public class LostAndFoundDTO {

    private Long itemId;

    private String description;

    private Date foundAt;

    private Boolean claimed;

    private ParkingLotModel parkingLot;

    private Date createdAt;
    private Date updatedAt;

    public LostAndFoundDTO() {

    }

    public LostAndFoundDTO(Long itemId, String description, Date foundAt, Boolean claimed, ParkingLotModel parkingLot, Date createdAt, Date updatedAt) {
        this.itemId = itemId;
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

}
