package com.example.accommodation_api.dto.response;

import com.example.accommodation_api.model.enums.AccommodationCategory;
import com.example.accommodation_api.model.enums.AccommodationCondition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Accommodation response")
public class AccommodationResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private AccommodationCategory category;
    private AccommodationCondition condition;
    private Boolean isRented;
    private Integer numRooms;
    private HostResponse host;
}