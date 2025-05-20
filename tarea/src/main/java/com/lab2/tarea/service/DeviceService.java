package com.lab2.tarea.service;

import com.lab2.tarea.model.Device;
import com.lab2.tarea.model.Subscription;
import com.lab2.tarea.repository.DeviceRepository;
import com.lab2.tarea.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getSubscriptionsById(UUID id) {
        return deviceRepository.findById(id).orElse(null);
    }

}
