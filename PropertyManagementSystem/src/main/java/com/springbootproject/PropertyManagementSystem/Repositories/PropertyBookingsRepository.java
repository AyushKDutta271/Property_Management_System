package com.springbootproject.PropertyManagementSystem.Repositories;

import com.springbootproject.PropertyManagementSystem.Entities.PropertyBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyBookingsRepository extends JpaRepository<PropertyBookings,Long> {
}
