package com.example.PropertyManagementSystem.Repository;


import com.example.PropertyManagementSystem.CATEGORY;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepo extends CrudRepository<ConsumersEntity,Long> {
    List<ConsumersEntity> findAllConsumersByCategory(CATEGORY category);

}
