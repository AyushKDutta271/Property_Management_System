package com.example.PropertyManagementSystem.Repository;


import com.example.PropertyManagementSystem.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyEntity,Long> {
    List<PropertyEntity> findAllPropertiesByOwner(Long ownerId);
    List<PropertyEntity> findAllByStatus(String status);

//    @Query("SELECT p FROM PropertyEntity p WHERE p.PropertyEntity.sellerId=:sellerId")
//    List<PropertyEntity> findAllBySellerId(@Param("sellerId") Long SellerId);
}
