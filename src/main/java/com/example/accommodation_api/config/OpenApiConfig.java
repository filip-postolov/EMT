package com.example.accommodation_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI accommodationOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Accommodation Rental API")
                        .description("""
                                REST API for managing accommodation rentals.
                                
                                Supported operations:
                                - Add a new accommodation
                                - Update an existing accommodation
                                - Delete an accommodation (only when in BAD condition)
                                - Mark an accommodation as rented
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Lab Exercise")
                                .email("lab@finki.ukim.mk")));
    }
}
