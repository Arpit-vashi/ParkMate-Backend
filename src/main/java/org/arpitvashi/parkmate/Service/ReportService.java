package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.ReportDTO;

import java.util.List;

public interface ReportService {

    ReportDTO createReport(ReportDTO report);

    List<ReportDTO> getAllReports();

    ReportDTO getReportById(Long id);

    ReportDTO updateReport(Long id, ReportDTO reportDTO);

    void deleteReport(Long id);

}
