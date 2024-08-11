package org.arpitvashi.parkmate.Dto;

import java.sql.Timestamp;
import java.util.Date;

public class UserDTO {

    private Long userId;

    private String name;
    private String username;
    private String email;
    private Long mobileNo;
    private String password;
    private Date createdAt;

    private Date updatedAt;

    public UserDTO() {}

    public UserDTO(Long userId, String name, String username, String email, Long mobileNo, String password, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }


    @Override
    public String toString() {
        return "usersDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" +email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}