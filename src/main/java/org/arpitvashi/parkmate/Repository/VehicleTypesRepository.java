package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.VehicleTypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypesRepository extends JpaRepository<VehicleTypesModel, Long> {
}
