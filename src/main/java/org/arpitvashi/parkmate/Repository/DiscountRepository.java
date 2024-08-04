package org.arpitvashi.parkmate.Repository;

import org.arpitvashi.parkmate.Model.DiscountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountModel, Long> {
}
