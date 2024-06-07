package com.farhad.example.amenity_reservation.repos;

import com.farhad.example.amenity_reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
