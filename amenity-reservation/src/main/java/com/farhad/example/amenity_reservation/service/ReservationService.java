package com.farhad.example.amenity_reservation.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.farhad.example.amenity_reservation.domain.Reservation;
import com.farhad.example.amenity_reservation.domain.User;
import com.farhad.example.amenity_reservation.model.ReservationDTO;
import com.farhad.example.amenity_reservation.repos.ReservationRepository;
import com.farhad.example.amenity_reservation.repos.UserRepository;
import com.farhad.example.amenity_reservation.util.NotFoundException;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(final ReservationRepository reservationRepository,
            final UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<ReservationDTO> findAll() {
        final List<Reservation> reservations = reservationRepository.findAll(Sort.by("id"));
        return reservations.stream()
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .toList();
    }

    public ReservationDTO get(final Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation();
        mapToEntity(reservationDTO, reservation);
        return reservationRepository.save(reservation).getId();
    }

    public void update(final Long id, final ReservationDTO reservationDTO) {
        final Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
    }

    public void delete(final Long id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO mapToDTO(final Reservation reservation,
            final ReservationDTO reservationDTO) {
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setUser(reservation.getUser() == null ? null : reservation.getUser().getId());
        return reservationDTO;
    }

    private Reservation mapToEntity(final ReservationDTO reservationDTO,
            final Reservation reservation) {
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        final User user = reservationDTO.getUser() == null ? null : userRepository.findById(reservationDTO.getUser())
                .orElseThrow(() -> new NotFoundException("user not found"));
        reservation.setUser(user);
        return reservation;
    }

}
