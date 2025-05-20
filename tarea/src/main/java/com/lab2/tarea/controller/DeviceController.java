package com.lab2.tarea.controller;

import com.lab2.tarea.model.Device;
import com.lab2.tarea.model.Subscription;
import com.lab2.tarea.service.DeviceService;
import com.lab2.tarea.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> createSubscription(@RequestBody Device device) {
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.ok(createdDevice);
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllSubscriptions() {
        List<Device>  devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getSubscription(@PathVariable UUID id) {
        Device device = deviceService.getSubscriptionsById(id);
        return ResponseEntity.ok(device);
    }
}
