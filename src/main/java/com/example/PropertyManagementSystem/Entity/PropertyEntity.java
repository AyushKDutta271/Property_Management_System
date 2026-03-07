package com.example.PropertyManagementSystem.Entity;

import com.example.PropertyManagementSystem.PropertyType;
import com.example.PropertyManagementSystem.STATUS;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity

@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long sellerId;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    @ManyToOne(fetch=FetchType.EAGER)//it'll not fetch consumer's data while etching property data...otherwise 'eager'
    @JoinColumn(name="owner_id", nullable = false)
    private ConsumersEntity owner;

    public PropertyEntity(Long sellerId, STATUS status, PropertyType type, ConsumersEntity owner)
    {
        this.sellerId=sellerId;
        this.status=status;
        this.type=type;
        this.owner=owner;
    }

}
