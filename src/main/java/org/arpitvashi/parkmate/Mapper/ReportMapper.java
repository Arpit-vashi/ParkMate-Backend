package org.arpitvashi.parkmate.Mapper;

import org.arpitvashi.parkmate.Dto.ReportDTO;
import org.arpitvashi.parkmate.Model.ReportModel;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDTO toDTO(ReportModel model) {
        ReportDTO dto = new ReportDTO();
        dto.setReportId(model.getReportId());
        dto.setReportType(model.getReportType());
        dto.setGeneratedDate(model.getGeneratedDate());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static ReportModel toEntity(ReportDTO dto) {
        ReportModel model = new ReportModel();
        model.setReportId(dto.getReportId());
        model.setReportType(dto.getReportType());
        model.setGeneratedDate(dto.getGeneratedDate());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());
        return model;
    }

}
