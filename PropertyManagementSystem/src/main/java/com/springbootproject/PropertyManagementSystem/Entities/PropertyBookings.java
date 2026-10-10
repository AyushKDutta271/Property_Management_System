package com.springbootproject.PropertyManagementSystem.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PropertyBookings {

    @Id
    private Long id;
    private String propertyName;
    private String propertyDescription;


    private Category propertyCategory;


    private Long sellerId;
    private Long ownerId;
}
