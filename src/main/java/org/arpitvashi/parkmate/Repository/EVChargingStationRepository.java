package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.EVChargingStationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EVChargingStationRepository extends JpaRepository<EVChargingStationModel, Long> {
}
