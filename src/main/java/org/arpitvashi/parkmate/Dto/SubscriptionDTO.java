package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.UserModel;

import java.util.Date;

public class SubscriptionDTO {

    private Long subscriptionId;

    private UserModel user;

    private Date startDate;

    private Date endDate;

    private String subscriptionType;

    private Date createdAt;

    private Date updatedAt;

    public SubscriptionDTO() {

    }

    public SubscriptionDTO(Long subscriptionId, UserModel user, Date startDate, Date endDate, String subscriptionType, Date createdAt, Date updatedAt) {
        this.subscriptionId = subscriptionId;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptionType = subscriptionType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

}

