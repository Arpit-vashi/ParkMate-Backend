package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.AlertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<AlertModel, Long> {
}
