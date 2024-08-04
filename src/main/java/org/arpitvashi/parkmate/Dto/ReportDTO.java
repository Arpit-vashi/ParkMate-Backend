package org.arpitvashi.parkmate.Dto;


import java.util.Date;

public class ReportDTO {

    private Long reportId;

    private String reportType;

    private Date generatedDate;

    private Date createdAt;

    private Date updatedAt;

    public ReportDTO() {

    }

    public ReportDTO(Long reportId, String reportType, Date generatedDate, Date createdAt, Date updatedAt) {
        this.reportId = reportId;
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

}
