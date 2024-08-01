package org.arpitvashi.parkmate.Dto;

import org.arpitvashi.parkmate.Model.UserModel;

import java.math.BigInteger;
import java.util.Date;

public class LoyaltyProgramDTO {

    private Long loyaltyId;

    private BigInteger points;

    private String rewards;

    private UserModel user;

    private Date createdAt;

    private Date updatedAt;

    public LoyaltyProgramDTO() {

    }

    public LoyaltyProgramDTO(Long loyaltyId, BigInteger points, String rewards, UserModel user, Date createdAt, Date updatedAt) {
        this.loyaltyId = loyaltyId;
        this.points = points;
        this.rewards = rewards;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

        public Long getLoyaltyId() { return loyaltyId; }

        public void setLoyaltyId(Long loyaltyId) {
            this.loyaltyId = loyaltyId;
        }

        public BigInteger getPoints() {
            return points;
        }

        public void setPoints(BigInteger points) {
            this.points = points;
        }

        public String getRewards() {
            return rewards;
        }

        public void setRewards(String rewards) {
            this.rewards = rewards;
        }

        public UserModel getUser() {
            return user;
        }

        public void setUser(UserModel user) {
            this.user = user;
        }

        public Date getCreatedAt() { return createdAt; }

        public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

        public Date getUpdatedAt() { return updatedAt; }

        public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    }


