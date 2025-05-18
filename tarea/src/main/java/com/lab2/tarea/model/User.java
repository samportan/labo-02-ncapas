package com.lab2.tarea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue
    private UUID id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Device> devices;
}
