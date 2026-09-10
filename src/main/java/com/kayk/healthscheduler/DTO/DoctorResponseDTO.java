package com.kayk.healthscheduler.DTO;

import com.kayk.healthscheduler.entities.Doctor;

import java.math.BigDecimal;

public record DoctorResponseDTO(
        Long id,
        String name,
        String crm,
        BigDecimal price,
        SpecialityResponseDTO speciality
) {
    public DoctorResponseDTO(Doctor entity) {
        this(entity.getId(), entity.getName(), entity.getCrm(), entity.getPrice(), entity.getSpeciality() != null ? new SpecialityResponseDTO(entity.getSpeciality()) : null );
    }
}
