package com.example.accommodation_api.controller;

import com.example.accommodation_api.dto.request.CreateHostRequest;
import com.example.accommodation_api.dto.response.HostResponse;
import com.example.accommodation_api.service.HostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@RequiredArgsConstructor
@Tag(name = "Hosts", description = "Endpoints for managing hosts")
public class HostController {

    private final HostService hostService;

    @Operation(summary = "Get all hosts")
    @GetMapping
    public ResponseEntity<List<HostResponse>> getAll() {
        return ResponseEntity.ok(hostService.getAll());
    }

    @Operation(summary = "Get host by ID")
    @GetMapping("/{id}")
    public ResponseEntity<HostResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getById(id));
    }

    @Operation(summary = "Create a new host")
    @PostMapping
    public ResponseEntity<HostResponse> create(@RequestBody CreateHostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hostService.create(request));
    }
}
