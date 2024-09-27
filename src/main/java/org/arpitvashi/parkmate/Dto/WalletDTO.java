package org.arpitvashi.parkmate.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class WalletDTO {

    private Long id;

    @NotNull(message = "User ID cannot be null")
    private Long userId; // To associate with the User

    @NotNull(message = "Balance cannot be null")
    @Positive(message = "Balance must be a positive value")
    private double balance;

    @NotNull(message = "Rewards points cannot be null")
    @Positive(message = "Rewards points must be a positive value")
    private int rewardsPoints;

    @NotNull(message = "Card number cannot be null")
    @Size(min = 16, max = 16, message = "Card number must be 16 digits")
    private String cardNumber;

    @NotNull(message = "Card PIN cannot be null")
    @Size(min = 4, max = 4, message = "Card PIN must be 4 digits")
    private String cardPin;

    private boolean isFrozen = false; // Default to false
    private boolean isDisabled = false; // Default to false

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
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
}
