package com.kayk.healthscheduler.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientRequestDTO(
        Long id,
        @NotBlank(message = "This empty field name cannot be used")
        String name,
        @NotBlank(message = "This empty field email cannot be used")
        @Email(message = "Email required")
        String email,
        String phone
) {
}
