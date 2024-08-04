package org.arpitvashi.parkmate.Controller;


import jakarta.validation.Valid;
import org.arpitvashi.parkmate.Dto.ReportDTO;
import org.arpitvashi.parkmate.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getAllReports() {
        List<ReportDTO> reports = reportService.getAllReports();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable("id") Long id) {
        ReportDTO reports = reportService.getReportById(id);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReportDTO> createReport(@Valid @RequestBody ReportDTO reportDTO) {
        ReportDTO createdReport = reportService.createReport(reportDTO);
        return ResponseEntity.ok(createdReport);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportDTO> updateReport(@PathVariable("id") Long id, @RequestBody ReportDTO reportDTO) {
        reportDTO.setReportId(id);
        ReportDTO updatedReport = reportService.updateReport(id, reportDTO);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable("id") Long id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
