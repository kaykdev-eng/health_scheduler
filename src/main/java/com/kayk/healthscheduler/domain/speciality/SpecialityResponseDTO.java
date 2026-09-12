package com.kayk.healthscheduler.domain.speciality;

import java.util.UUID;

public record SpecialityResponseDTO(
        UUID id,
        String name
) {
    public SpecialityResponseDTO(Speciality entity) {
        this(entity.getId(), entity.getName());
    }
}
