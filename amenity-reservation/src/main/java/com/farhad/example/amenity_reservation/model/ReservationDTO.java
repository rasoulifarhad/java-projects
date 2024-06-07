package com.farhad.example.amenity_reservation.model;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private Long id;

    private LocalDate reservationDate;

    @Schema(type = "string", example = "18:30")
    private LocalTime startTime;

    @Schema(type = "string", example = "18:30")
    private LocalTime endTime;

    private Long user;

}
