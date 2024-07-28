package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.SubscriptionDTO;
import org.arpitvashi.parkmate.Mapper.SubscriptionMapper;
import org.arpitvashi.parkmate.Model.SubscriptionModel;
import org.arpitvashi.parkmate.Model.UserModel;
import org.arpitvashi.parkmate.Repository.SubscriptionRepository;
import org.arpitvashi.parkmate.Repository.UserRepository;
import org.arpitvashi.parkmate.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private final SubscriptionRepository subscriptionRepository;

    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, UserRepository userRepository, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Override
    public List<SubscriptionDTO> getAllSubscriptions() {
        List<SubscriptionModel> subscriptions = subscriptionRepository.findAll();
        return subscriptions.stream()
                .map(subscriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionDTO getSubscriptionById(Long id) {
        SubscriptionModel subscriptions = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));
        return subscriptionMapper.toDTO(subscriptions);
    }


    @Override
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        if (subscriptionDTO.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        UserModel user = userRepository.findById(subscriptionDTO.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SubscriptionModel subscription = new SubscriptionModel();
        subscription.setUser(user);
        subscription.setStartDate(subscriptionDTO.getStartDate());
        subscription.setEndDate(subscriptionDTO.getEndDate());
        subscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
        subscription.setCreatedAt(subscriptionDTO.getCreatedAt());
        subscription.setUpdatedAt(subscriptionDTO.getUpdatedAt());

        SubscriptionModel savedSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.toDTO(savedSubscription);
    }

    @Override
    public SubscriptionDTO updateSubscription(Long id, SubscriptionDTO subscriptionDTO) {
        SubscriptionModel existingSubscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id: " + id));

        if (subscriptionDTO.getUser() != null) {
            UserModel user = userRepository.findById(subscriptionDTO.getUser().getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existingSubscription.setUser(user);
        }

        if(subscriptionDTO.getStartDate()!=null){
            existingSubscription.setStartDate(subscriptionDTO.getStartDate());
        }
        if(subscriptionDTO.getEndDate()!= null) {
            existingSubscription.setEndDate(subscriptionDTO.getEndDate());
        }
        if(subscriptionDTO.getSubscriptionType()!= null) {
            existingSubscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
        }
        if(subscriptionDTO.getCreatedAt()!= null) {
            existingSubscription.setCreatedAt(subscriptionDTO.getCreatedAt());
        }
        if(subscriptionDTO.getUpdatedAt()!= null) {
            existingSubscription.setUpdatedAt(subscriptionDTO.getUpdatedAt());
        }

        SubscriptionModel updatedSubscription = subscriptionRepository.save(existingSubscription);
        return subscriptionMapper.toDTO(updatedSubscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        if (!subscriptionRepository.existsById(id)) {
            throw new RuntimeException("Subscription not found with id: " + id);
        }
        subscriptionRepository.deleteById(id);
    }


}
