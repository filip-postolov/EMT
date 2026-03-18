package com.example.accommodation_api.service;

import com.example.accommodation_api.dto.request.CreateAccommodationRequest;
import com.example.accommodation_api.dto.request.UpdateAccommodationRequest;
import com.example.accommodation_api.dto.response.AccommodationResponse;

import java.util.List;

public interface AccommodationService {

    AccommodationResponse create(CreateAccommodationRequest request);

    AccommodationResponse update(Long id, UpdateAccommodationRequest request);

    void delete(Long id);

    AccommodationResponse markAsRented(Long id);

    AccommodationResponse getById(Long id);

    List<AccommodationResponse> getAll();
}