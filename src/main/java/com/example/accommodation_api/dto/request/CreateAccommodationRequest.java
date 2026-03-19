package com.example.accommodation_api.dto.request;

import com.example.accommodation_api.model.enums.AccommodationCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAccommodationRequest {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    @Schema(description = "Name of the accommodation", example = "Cozy Flat in City Center")
    private String name;

    @NotNull(message = "Category must not be null")
    @Schema(description = "Category of the accommodation", example = "FLAT")
    private AccommodationCategory category;

    @NotNull(message = "Number of rooms must not be null")
    @Min(value = 1, message = "Number of rooms must be at least 1")
    @Schema(description = "Number of rooms", example = "2")
    private Integer numRooms;

    @NotNull(message = "Host ID must not be null")
    @Schema(description = "ID of the host", example = "1")
    private Long hostId;
}
