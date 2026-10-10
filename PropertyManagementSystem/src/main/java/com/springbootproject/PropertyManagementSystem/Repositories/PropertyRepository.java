package com.springbootproject.PropertyManagementSystem.Repositories;

import com.springbootproject.PropertyManagementSystem.DTO.UserDto;
import com.springbootproject.PropertyManagementSystem.Entities.Category;
import com.springbootproject.PropertyManagementSystem.Entities.Property;
import com.springbootproject.PropertyManagementSystem.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

    @Query(value = "SELECT * FROM property p WHERE p.seller_id=:userId",nativeQuery = true)
   Page<Property> findBySellerId(@Param("userId") User userId,Pageable pageable);
   Page<Property> findByPropertyCategory(Category category, Pageable pageable);
}
