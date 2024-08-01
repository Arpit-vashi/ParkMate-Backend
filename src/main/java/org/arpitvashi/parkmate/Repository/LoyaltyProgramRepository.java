package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.LoyaltyProgramModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgramModel, Long> {


}
