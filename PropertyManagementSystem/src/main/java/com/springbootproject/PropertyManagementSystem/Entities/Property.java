package com.springbootproject.PropertyManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Property {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String propertyName;
    private String propertyDescription;

    @Enumerated(EnumType.STRING)
    private Category propertyCategory;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private User sellerId;


}
