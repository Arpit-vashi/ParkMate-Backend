package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.ReportDTO;
import org.arpitvashi.parkmate.Mapper.ReportMapper;
import org.arpitvashi.parkmate.Model.ReportModel;
import org.arpitvashi.parkmate.Repository.*;
import org.arpitvashi.parkmate.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private final ReportRepository reportRepository;

    private final ReportMapper reportMapper;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    @Override
    public List<ReportDTO> getAllReports() {
        List<ReportModel> discounts = reportRepository.findAll();
        return discounts.stream()
                .map(reportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportDTO getReportById(Long id) {
        ReportModel report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id: " + id));
        return reportMapper.toDTO(report);
    }

    @Override
    public ReportDTO createReport(ReportDTO reportDTO) {
        ReportModel report = reportMapper.toEntity(reportDTO);
        ReportModel savedReport = reportRepository.save(report);
        return reportMapper.toDTO(savedReport);
    }

    @Override
    public ReportDTO updateReport(Long id, ReportDTO reportDTO) {
        ReportModel existingReport = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id: " + id));

        if (reportDTO.getReportType() != null) {
            existingReport.setReportType(reportDTO.getReportType());
        }
        if (reportDTO.getGeneratedDate() != null) {
            existingReport.setGeneratedDate(reportDTO.getGeneratedDate());
        }
        if (reportDTO.getCreatedAt() != null) {
            existingReport.setCreatedAt(reportDTO.getCreatedAt());
        }
        if (reportDTO.getUpdatedAt() != null) {
            existingReport.setUpdatedAt(reportDTO.getUpdatedAt());
        }

        existingReport.setUpdatedAt(new Date());
        ReportModel updatedReport = reportRepository.save(existingReport);
        return reportMapper.toDTO(updatedReport);
    }

    @Override
    public void deleteReport(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new RuntimeException("Report not found with id: " + id);
        }
        reportRepository.deleteById(id);
    }

}
