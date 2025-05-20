package com.lab2.tarea.service;

import com.lab2.tarea.model.Subscription;
import com.lab2.tarea.model.User;
import com.lab2.tarea.repository.SubscriptionRepository;
import com.lab2.tarea.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionsById(UUID id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

}
