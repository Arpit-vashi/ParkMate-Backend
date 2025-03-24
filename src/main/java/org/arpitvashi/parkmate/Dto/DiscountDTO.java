package org.arpitvashi.parkmate.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class DiscountDTO {

    private Long discountId;

    private String code;

    private String description;

    private BigDecimal discountPercentage;

    private Date validFrom;

    private Date validTo;

    private Date createdAt;

    private Date updatedAt;

    public DiscountDTO() {

    }

    public DiscountDTO(Long discountId, String code, String description, BigDecimal discountPercentage, Date validFrom, Date validTo, Date createdAt, Date updatedAt) {
        this.discountId = discountId;
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

}
