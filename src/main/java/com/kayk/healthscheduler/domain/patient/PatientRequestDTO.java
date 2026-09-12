package com.kayk.healthscheduler.domain.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record PatientRequestDTO(
        UUID id,
        @NotBlank(message = "This empty field name cannot be used")
        String name,
        @NotBlank(message = "This empty field email cannot be used")
        @Email(message = "Email required")
        String email,
        String phone
) {
}
