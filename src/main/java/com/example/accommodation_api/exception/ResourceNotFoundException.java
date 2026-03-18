package com.example.accommodation_api.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException forAccommodation(Long id) {
        return new ResourceNotFoundException("Accommodation not found with id: " + id);
    }

    public static ResourceNotFoundException forHost(Long id) {
        return new ResourceNotFoundException("Host not found with id: " + id);
    }

    public static ResourceNotFoundException forCountry(Long id) {
        return new ResourceNotFoundException("Country not found with id: " + id);
    }
}