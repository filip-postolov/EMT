package com.example.accommodation_api.service;

import com.example.accommodation_api.model.Accommodation;
import com.example.accommodation_api.model.Reservation;
import com.example.accommodation_api.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    Reservation getById(Long id);

    List<Reservation> getAll();

    Reservation create(User user, Accommodation accommodation, LocalDate from, LocalDate to);
}
