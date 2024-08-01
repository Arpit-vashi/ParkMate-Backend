package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name = "LoyaltyPrograms")
public class LoyaltyProgramModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loyalty_id")
    private Long loyaltyId;

    @Column(name = "points", nullable = false)
    private BigInteger points;

    @Column(name = "rewards", length = 255)
    private String rewards;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public LoyaltyProgramModel() {
    }

    public LoyaltyProgramModel(BigInteger points, String rewards, UserModel user, Date createdAt, Date updatedAt) {
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
