package com.kayk.healthscheduler.domain.patient;


import java.util.UUID;

public record PatientResponseDTO(
        UUID id,
        String name,
        String email,
        String phone
) {
        public PatientResponseDTO(Patient entity) {
                this(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone());
        }
}
