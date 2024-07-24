package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {

    boolean existsByLicensePlate(String licensePlate);

}
