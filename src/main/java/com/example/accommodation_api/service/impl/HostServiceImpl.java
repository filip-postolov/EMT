package com.example.accommodation_api.service.impl;

import com.example.accommodation_api.exception.ResourceNotFoundException;
import com.example.accommodation_api.dto.request.CreateHostRequest;
import com.example.accommodation_api.dto.response.CountryResponse;
import com.example.accommodation_api.dto.response.HostResponse;
import com.example.accommodation_api.model.Country;
import com.example.accommodation_api.model.Host;
import com.example.accommodation_api.repository.CountryRepository;
import com.example.accommodation_api.repository.HostRepository;
import com.example.accommodation_api.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    @Override
    public HostResponse create(CreateHostRequest request) {
        Country country = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> ResourceNotFoundException.forCountry(request.getCountryId()));

        Host host = Host.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .country(country)
                .build();

        return mapToResponse(hostRepository.save(host));
    }

    @Override
    public HostResponse getById(Long id) {
        return hostRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> ResourceNotFoundException.forHost(id));
    }

    @Override
    public List<HostResponse> getAll() {
        return hostRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private HostResponse mapToResponse(Host host) {
        return HostResponse.builder()
                .id(host.getId())
                .createdAt(host.getCreatedAt())
                .updatedAt(host.getUpdatedAt())
                .name(host.getName())
                .surname(host.getSurname())
                .country(mapCountryToResponse(host.getCountry()))
                .build();
    }

    private CountryResponse mapCountryToResponse(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(country.getContinent())
                .build();
    }

}
