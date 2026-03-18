package com.example.accommodation_api.dto.request;

import com.example.accommodation_api.model.enums.AccommodationCategory;
import com.example.accommodation_api.model.enums.AccommodationCondition;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request body for updating an existing accommodation")
public class UpdateAccommodationRequest {

    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    @Schema(description = "New name of the accommodation", example = "Updated Flat Name")
    private String name;

    @Schema(description = "New category", example = "APARTMENT")
    private AccommodationCategory category;

    @Schema(description = "New condition", example = "GOOD")
    private AccommodationCondition condition;

    @Min(value = 1, message = "Number of rooms must be at least 1")
    @Schema(description = "New number of rooms", example = "3")
    private Integer numRooms;

    @Schema(description = "New host ID", example = "2")
    private Long hostId;
}