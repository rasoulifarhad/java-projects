package com.farhad.example.amenity_reservation.repos;

import com.farhad.example.amenity_reservation.domain.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CapacityRepository extends JpaRepository<Capacity, Long> {
}
