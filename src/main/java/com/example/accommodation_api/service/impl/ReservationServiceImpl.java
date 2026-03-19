package com.example.accommodation_api.service.impl;

import com.example.accommodation_api.dto.response.CountryResponse;
import com.example.accommodation_api.exception.ResourceNotFoundException;
import com.example.accommodation_api.model.Accommodation;
import com.example.accommodation_api.model.Reservation;
import com.example.accommodation_api.model.User;
import com.example.accommodation_api.repository.ReservationRepository;
import com.example.accommodation_api.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation create(User user, Accommodation accommodation, LocalDate from, LocalDate to) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setAccommodation(accommodation);
        reservation.setFrom(from);
        reservation.setTo(to);
        return reservationRepository.save(reservation);
    }
}
