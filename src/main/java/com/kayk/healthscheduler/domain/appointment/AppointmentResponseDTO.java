package com.kayk.healthscheduler.domain.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kayk.healthscheduler.domain.doctor.DoctorResponseDTO;
import com.kayk.healthscheduler.domain.patient.PatientResponseDTO;
import com.kayk.healthscheduler.domain.enums.AppointmentStatus;

import java.time.Instant;
import java.util.UUID;

public record AppointmentResponseDTO(
        UUID id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment,
        AppointmentStatus status,
        String notes,
        PatientResponseDTO patient,
        DoctorResponseDTO doctor
) {
    public AppointmentResponseDTO(Appointment entity) {
        this(entity.getId(), entity.getMoment(), entity.getStatus(), entity.getNotes(), entity.getPatient() != null ? new PatientResponseDTO(entity.getPatient()) : null, entity.getDoctor().getId() != null ? new DoctorResponseDTO(entity.getDoctor()) : null);
    }

}
