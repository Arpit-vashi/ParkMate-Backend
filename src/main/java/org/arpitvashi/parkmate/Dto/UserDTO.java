package org.arpitvashi.parkmate.Dto;

import java.sql.Timestamp;

public class UserDTO {

    private Long userId;

    private String name;
    private String username;
    private String email;
    private Long mobileNo;
    private String role;
    private String password;
    private Timestamp createdAt;

    public UserDTO() {}

    public UserDTO(Long userId, String name, String username, String email, Long mobileNo, String role, String password, Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "usersDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" +email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}