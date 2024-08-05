package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.UserModel;

import java.util.Date;

public class AlertDTO {

    private Long alertId;
    private String message;
    private Date alertTime;
    private UserModel user;
    private Date createdAt;
    private Date updatedAt;

    public AlertDTO() {}

    public AlertDTO(Long alertId, String message, Date alertTime, UserModel user, Date createdAt, Date updatedAt) {
        this.alertId = alertId;
        this.message = message;
        this.alertTime = alertTime;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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
