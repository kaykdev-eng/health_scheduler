package com.kayk.healthscheduler.domain.speciality;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record SpecialityRequestDTO(
        UUID id,
        @NotBlank(message = "This field cannot be left blank.")
        String name
) {
}
