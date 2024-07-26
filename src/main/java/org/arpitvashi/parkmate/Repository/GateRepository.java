package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.GateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<GateModel, Long> {
}
