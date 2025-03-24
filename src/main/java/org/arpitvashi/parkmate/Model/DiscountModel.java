package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Discounts")
public class DiscountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiscountID")
    private Long discountId;

    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    @Column(name = "Description", length = 300)
    private String description;

    @Column(name = "DiscountPercentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "ValidFrom", nullable = false)
    private Date validFrom;

    @Column(name = "ValidTo", nullable = false)
    private Date validTo;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    public DiscountModel() {
    }

    public DiscountModel(String code, String description, BigDecimal discountPercentage, Date validFrom, Date validTo, Date createdAt, Date updatedAt) {
        this.code = code;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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

