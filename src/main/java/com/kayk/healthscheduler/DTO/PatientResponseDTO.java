package com.kayk.healthscheduler.DTO;


import com.kayk.healthscheduler.entities.Patient;

public record PatientResponseDTO(
        Long id,
        String name,
        String email,
        String phone
) {
        public PatientResponseDTO(Patient entity) {
                this(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone());
        }
}
