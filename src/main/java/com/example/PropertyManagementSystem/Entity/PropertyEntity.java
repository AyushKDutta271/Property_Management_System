package com.example.PropertyManagementSystem.Entity;

import com.example.PropertyManagementSystem.PropertyType;
import com.example.PropertyManagementSystem.STATUS;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long sellerId;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    private Long ownerId;

}
