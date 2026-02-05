package com.example.PropertyManagementSystem.Entity;

import com.example.PropertyManagementSystem.CATEGORY;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class ConsumersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Boolean permission;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    private Long propertyId;
}
