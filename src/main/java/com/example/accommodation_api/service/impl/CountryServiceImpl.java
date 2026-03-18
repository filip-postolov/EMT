package com.example.accommodation_api.service.impl;

import com.example.accommodation_api.exception.ResourceNotFoundException;
import com.example.accommodation_api.dto.response.CountryResponse;
import com.example.accommodation_api.model.Country;
import com.example.accommodation_api.repository.CountryRepository;
import com.example.accommodation_api.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public CountryResponse getById(Long id) {
        return countryRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> ResourceNotFoundException.forCountry(id));
    }

    @Override
    public List<CountryResponse> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CountryResponse mapToResponse(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(country.getContinent())
                .build();
    }

}
