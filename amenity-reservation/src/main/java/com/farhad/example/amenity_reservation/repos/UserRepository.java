package com.farhad.example.amenity_reservation.repos;

import com.farhad.example.amenity_reservation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
