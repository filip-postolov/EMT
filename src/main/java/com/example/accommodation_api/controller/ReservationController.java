package com.example.accommodation_api.controller;

import com.example.accommodation_api.dto.request.CreateAccommodationRequest;
import com.example.accommodation_api.dto.response.AccommodationResponse;
import com.example.accommodation_api.dto.response.CountryResponse;
import com.example.accommodation_api.model.Accommodation;
import com.example.accommodation_api.model.Reservation;
import com.example.accommodation_api.model.User;
import com.example.accommodation_api.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(reservationService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> create(
            @RequestBody User user,
            @RequestBody Accommodation accommodation,
            @RequestBody LocalDate from,
            @RequestBody LocalDate to) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.create(user, accommodation, from, to));
    }

}
