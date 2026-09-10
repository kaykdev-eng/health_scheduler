package com.kayk.healthscheduler.DTO;

import jakarta.validation.constraints.NotBlank;

public record SpecialityRequestDTO(
        Long id,
        @NotBlank(message = "This field cannot be left blank.")
        String name
) {
}
