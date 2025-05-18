package com.lab2.tarea.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id @GeneratedValue
    private UUID id;

    private String type;

    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
