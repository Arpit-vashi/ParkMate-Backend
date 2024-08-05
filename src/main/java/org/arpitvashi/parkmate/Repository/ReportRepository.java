package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Long> {
}
