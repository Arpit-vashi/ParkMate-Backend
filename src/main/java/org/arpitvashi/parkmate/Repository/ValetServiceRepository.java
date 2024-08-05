package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.ValetServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValetServiceRepository extends JpaRepository<ValetServiceModel, Long> {
}
