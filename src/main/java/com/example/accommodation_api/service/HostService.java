package com.example.accommodation_api.service;

import com.example.accommodation_api.dto.request.CreateHostRequest;
import com.example.accommodation_api.dto.response.HostResponse;

import java.util.List;

public interface HostService {

    HostResponse create(CreateHostRequest request);

    HostResponse getById(Long id);

    List<HostResponse> getAll();
}