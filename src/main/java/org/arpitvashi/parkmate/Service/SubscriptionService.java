package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.SubscriptionDTO;

import java.util.List;

public interface SubscriptionService {

    SubscriptionDTO createSubscription(SubscriptionDTO subscription);

    List<SubscriptionDTO> getAllSubscriptions();

    SubscriptionDTO getSubscriptionById(Long id);

    SubscriptionDTO updateSubscription(Long id, SubscriptionDTO subscriptionDTO);

    void deleteSubscription(Long id);

}
