package com.example.accommodation_api.service.impl;

import com.example.accommodation_api.exception.BusinessException;
import com.example.accommodation_api.exception.ResourceNotFoundException;
import com.example.accommodation_api.dto.request.CreateAccommodationRequest;
import com.example.accommodation_api.dto.request.UpdateAccommodationRequest;
import com.example.accommodation_api.dto.response.AccommodationResponse;
import com.example.accommodation_api.dto.response.CountryResponse;
import com.example.accommodation_api.dto.response.HostResponse;
import com.example.accommodation_api.model.Accommodation;
import com.example.accommodation_api.model.Host;
import com.example.accommodation_api.model.enums.AccommodationCondition;
import com.example.accommodation_api.repository.AccommodationRepository;
import com.example.accommodation_api.repository.HostRepository;
import com.example.accommodation_api.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    @Override
    public AccommodationResponse create(CreateAccommodationRequest request) {
        Host host = hostRepository.findById(request.getHostId())
                .orElseThrow(() -> ResourceNotFoundException.forHost(request.getHostId()));

        Accommodation accommodation = Accommodation.builder()
                .name(request.getName())
                .category(request.getCategory())
                .numRooms(request.getNumRooms())
                .host(host)
                .build();

        return mapToResponse(accommodationRepository.save(accommodation));
    }

    @Override
    public AccommodationResponse update(Long id, UpdateAccommodationRequest request) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.forAccommodation(id));

        if (request.getName() != null) {
            accommodation.setName(request.getName());
        }
        if (request.getCategory() != null) {
            accommodation.setCategory(request.getCategory());
        }
        if (request.getCondition() != null) {
            accommodation.setCondition(request.getCondition());
        }
        if (request.getNumRooms() != null) {
            accommodation.setNumRooms(request.getNumRooms());
        }
        if (request.getHostId() != null) {
            Host host = hostRepository.findById(request.getHostId())
                    .orElseThrow(() -> ResourceNotFoundException.forHost(request.getHostId()));
            accommodation.setHost(host);
        }

        return mapToResponse(accommodationRepository.save(accommodation));
    }

    @Override
    public void delete(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.forAccommodation(id));

        if (accommodation.getCondition() == AccommodationCondition.GOOD) {
            throw new BusinessException(
                    "Cannot delete accommodation with id " + id + " because it is still in GOOD condition.");
        }

        accommodationRepository.delete(accommodation);
    }

    @Override
    public AccommodationResponse markAsRented(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.forAccommodation(id));

        if (accommodation.getCondition() == AccommodationCondition.BAD) {
            throw new BusinessException(
                    "Cannot rent accommodation with id " + id + " because it is in BAD condition.");
        }

        if (Boolean.TRUE.equals(accommodation.getIsRented())) {
            throw new BusinessException(
                    "Accommodation with id " + id + " is already rented.");
        }

        accommodation.setIsRented(true);
        return mapToResponse(accommodationRepository.save(accommodation));
    }

    @Override
    public AccommodationResponse getById(Long id) {
        return accommodationRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> ResourceNotFoundException.forAccommodation(id));
    }

    @Override
    public List<AccommodationResponse> getAll() {
        return accommodationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AccommodationResponse mapToResponse(Accommodation accommodation) {
        return AccommodationResponse.builder()
                .id(accommodation.getId())
                .createdAt(accommodation.getCreatedAt())
                .updatedAt(accommodation.getUpdatedAt())
                .name(accommodation.getName())
                .category(accommodation.getCategory())
                .condition(accommodation.getCondition())
                .isRented(accommodation.getIsRented())
                .numRooms(accommodation.getNumRooms())
                .host(mapHostToResponse(accommodation.getHost()))
                .build();
    }

    private HostResponse mapHostToResponse(Host host) {
        return HostResponse.builder()
                .id(host.getId())
                .createdAt(host.getCreatedAt())
                .updatedAt(host.getUpdatedAt())
                .name(host.getName())
                .surname(host.getSurname())
                .country(CountryResponse.builder()
                        .id(host.getCountry().getId())
                        .name(host.getCountry().getName())
                        .continent(host.getCountry().getContinent())
                        .build())
                .build();
    }

}
