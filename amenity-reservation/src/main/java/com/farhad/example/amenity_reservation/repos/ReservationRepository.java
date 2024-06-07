package com.farhad.example.amenity_reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.amenity_reservation.domain.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
