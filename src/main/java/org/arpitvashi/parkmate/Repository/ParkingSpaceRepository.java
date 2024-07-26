package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.FloorModel;
import org.arpitvashi.parkmate.Model.ParkingSpaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceModel, Long> {
}


