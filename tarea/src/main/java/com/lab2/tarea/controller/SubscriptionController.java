package com.lab2.tarea.controller;


import com.lab2.tarea.model.Subscription;
import com.lab2.tarea.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
        return ResponseEntity.ok(createdSubscription);
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription>  subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable UUID id) {
        Subscription subscription = subscriptionService.getSubscriptionsById(id);
        return ResponseEntity.ok(subscription);
    }
}
