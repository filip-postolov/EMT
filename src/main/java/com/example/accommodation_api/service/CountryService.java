package com.example.accommodation_api.service;

import com.example.accommodation_api.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {

    CountryResponse getById(Long id);

    List<CountryResponse> getAll();
}