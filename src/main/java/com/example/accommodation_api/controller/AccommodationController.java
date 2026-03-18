package com.example.accommodation_api.controller;

import com.example.accommodation_api.dto.request.CreateAccommodationRequest;
import com.example.accommodation_api.dto.request.UpdateAccommodationRequest;
import com.example.accommodation_api.dto.response.AccommodationResponse;
import com.example.accommodation_api.service.AccommodationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
@Tag(name = "Accommodations", description = "Endpoints for managing accommodations")
public class AccommodationController {

    private final AccommodationService accommodationService;

    @Operation(summary = "Get all accommodations")
    @GetMapping
    public ResponseEntity<List<AccommodationResponse>> getAll() {
        return ResponseEntity.ok(accommodationService.getAll());
    }

    @Operation(summary = "Get accommodation by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AccommodationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.getById(id));
    }

    @Operation(summary = "Create a new accommodation")
    @PostMapping
    public ResponseEntity<AccommodationResponse> create(
            @RequestBody CreateAccommodationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accommodationService.create(request));
    }

    @Operation(summary = "Update an existing accommodation")
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateAccommodationRequest request) {
        return ResponseEntity.ok(accommodationService.update(id, request));
    }

    @Operation(summary = "Delete an accommodation (only if condition is BAD)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accommodationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Mark an accommodation as rented")
    @PatchMapping("/{id}/rent")
    public ResponseEntity<AccommodationResponse> markAsRented(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.markAsRented(id));
    }
}
