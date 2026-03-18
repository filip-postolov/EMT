package com.example.accommodation_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Country response")
public class CountryResponse {
    private Long id;
    private String name;
    private String continent;
}