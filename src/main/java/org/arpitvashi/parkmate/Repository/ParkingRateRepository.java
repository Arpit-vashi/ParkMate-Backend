package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ParkingRateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRateRepository extends JpaRepository<ParkingRateModel, Long> {
}
