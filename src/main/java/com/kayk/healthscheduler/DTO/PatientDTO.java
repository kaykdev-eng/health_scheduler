package com.kayk.healthscheduler.DTO;


import com.kayk.healthscheduler.entities.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PatientDTO(
        Long id,
        @NotBlank(message = "This empty field name cannot be used")
        String name,
        @Email(message = "Email required")
        String email,
        String phone
) {
        public PatientDTO(Patient entity) {
                this(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone());
        }
}
