package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ParkingHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingHistoryRepository extends JpaRepository<ParkingHistoryModel, Long> {
}
