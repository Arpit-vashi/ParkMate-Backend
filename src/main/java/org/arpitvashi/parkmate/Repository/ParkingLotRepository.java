package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ParkingLotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotModel, Long> {
}
