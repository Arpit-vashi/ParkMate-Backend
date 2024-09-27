package org.arpitvashi.parkmate.Dto;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private Long userId;
    private String name;
    private String username;
    private String email;
    private String mobileNo;
    private String password;
    private String address;
    private String city;
    private String state;
    private Long countryId;
    private String countryName;
    private WalletDTO wallet; // New field for wallet information
    private Date createdAt;
    private Date updatedAt;
    private List<String> walletDetails; // List to store wallet details

    public UserDTO() {}

    public UserDTO(Long userId, String name, String username, String email, String mobileNo, String password,
                   String address, String city, String state, Long countryId, String countryName,
                   WalletDTO wallet, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.countryId = countryId;
        this.countryName = countryName;
        this.wallet = wallet; // Initialize wallet object
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
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

    public List<String> getWalletDetails() {
        return walletDetails;
    }

    public void setWalletDetails(List<String> walletDetails) {
        this.walletDetails = walletDetails;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
