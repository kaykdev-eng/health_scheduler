package com.kayk.healthscheduler.domain.doctor;

import com.kayk.healthscheduler.domain.speciality.SpecialityResponseDTO;

import java.math.BigDecimal;
import java.util.UUID;

public record DoctorResponseDTO(
        UUID id,
        String name,
        String crm,
        BigDecimal price,
        SpecialityResponseDTO speciality
) {
    public DoctorResponseDTO(Doctor entity) {
        this(entity.getId(), entity.getName(), entity.getCrm(), entity.getPrice(), entity.getSpeciality() != null ? new SpecialityResponseDTO(entity.getSpeciality()) : null );
    }
}
