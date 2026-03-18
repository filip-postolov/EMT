package com.example.accommodation_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request body for creating a new host")
public class CreateHostRequest {

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "First name of the host", example = "Marko")
    private String name;

    @NotBlank(message = "Surname must not be blank")
    @Size(min = 2, max = 100, message = "Surname must be between 2 and 100 characters")
    @Schema(description = "Last name of the host", example = "Petrovski")
    private String surname;

    @NotNull(message = "Country ID must not be null")
    @Schema(description = "ID of the country", example = "1")
    private Long countryId;
}