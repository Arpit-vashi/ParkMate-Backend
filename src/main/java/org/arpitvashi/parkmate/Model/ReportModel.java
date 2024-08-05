package org.arpitvashi.parkmate.Model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "Reports")
public class ReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportID")
    private Long reportId;

    @Column(name = "ReportType", nullable = false)
    private String reportType;

    @Column(name = "GeneratedDate", nullable = false)
    private Date generatedDate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ReportModel() {}

    public ReportModel(String reportType, Date generatedDate, Date createdAt, Date updatedAt) {
        this.reportType = reportType;
        this.generatedDate = generatedDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
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
