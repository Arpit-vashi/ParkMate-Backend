package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wallets")
public class WalletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user; // Linking to the UserModel

    @Column(name = "balance", nullable = false)
    private Double balance; // Use Double to allow for null values if necessary

    @Column(name = "rewards_points", nullable = false)
    private int rewardsPoints;

    @Column(name = "card_number", nullable = false, unique = true) // Enforce uniqueness
    private String cardNumber;

    @Column(name = "card_pin", nullable = false)
    private String cardPin;

    @Column(name = "is_frozen", nullable = false)
    private boolean isFrozen; // Default value set in the constructor

    @Column(name = "is_disabled", nullable = false)
    private boolean isDisabled; // Default value set in the constructor

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Default constructor
    public WalletModel() {
        this.balance = 0.0; // Initialize balance to 0.0
        this.rewardsPoints = 0; // Initialize rewards points to 0
        this.isFrozen = false; // Default to false
        this.isDisabled = false; // Default to false
    }

    // Parameterized constructor (optional)
    public WalletModel(UserModel user, Double balance, int rewardsPoints, String cardNumber, String cardPin) {
        this.user = user;
        this.balance = balance;
        this.rewardsPoints = rewardsPoints;
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
        this.isFrozen = false; // Default to false
        this.isDisabled = false; // Default to false
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(int rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
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

    // Automatically set timestamps before persisting/updating
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
