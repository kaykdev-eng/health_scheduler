package com.kayk.healthscheduler.DTO;

import com.kayk.healthscheduler.entities.Speciality;

public record SpecialityResponseDTO(
        Long id,
        String name
) {
    public SpecialityResponseDTO(Speciality entity) {
        this(entity.getId(), entity.getName());
    }
}
