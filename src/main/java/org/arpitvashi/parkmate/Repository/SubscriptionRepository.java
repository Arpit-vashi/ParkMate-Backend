package org.arpitvashi.parkmate.Repository;


import org.arpitvashi.parkmate.Model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Long> {
}
