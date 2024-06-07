package com.farhad.example.amenity_reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.amenity_reservation.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
