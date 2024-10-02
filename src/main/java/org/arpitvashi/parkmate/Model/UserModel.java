package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users", indexes = {
        @Index(name = "idx_name", columnList = "full_name"),
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_mobileNo", columnList = "mobileno"),
        @Index(name = "idx_city", columnList = "city")
})
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "full_name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobileno", nullable = false, unique = true)
    private String mobileNo; // Changed to String to allow (countrycode)-(mobilenumber)

    @Column(name = "address", nullable = true)
    private String address; // Combined address field

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "state", nullable = true)
    private String state;

    // Many-to-One relationship with CountryModel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryModel country;

    // One-to-One relationship with WalletModel
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WalletModel wallet; // Linking to WalletModel

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public UserModel() {
    }

    public UserModel(String name, String username, String password, String email, String mobileNo, String address, String city, String state, CountryModel country, WalletModel wallet) {
        this.name = name;
        this.username = username;
        this.password = password; // Consider hashing this password before storing
        this.email = email;
        this.mobileNo = mobileNo; // Updated to use String for mobileNo
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country; // Associated CountryModel
        this.wallet = wallet; // Associated WalletModel
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; // Consider hashing before saving to DB
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

    public CountryModel getCountry() {
        return country; // Getter for associated CountryModel
    }

    public void setCountry(CountryModel country) { // Setter for associated CountryModel
        this.country = country;
    }

    public WalletModel getWallet() { // Getter for associated WalletModel
        return wallet;
    }

    public void setWallet(WalletModel wallet) { // Setter for associated WalletModel
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
