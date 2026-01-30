package com.example.PropertyManagementSystem.Repository;


import com.example.PropertyManagementSystem.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<PropertyEntity,Long> {
    List<PropertyEntity> findAllPropertiesByCustomerId(Long customerId);
    List<PropertyEntity> findAllByStatus(String status);
}
