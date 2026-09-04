package com.kayk.healthscheduler.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kayk.healthscheduler.entities.Appointment;
import com.kayk.healthscheduler.entities.enums.AppointmentStatus;

import java.time.Instant;

public record AppointmentDTO(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment,
        AppointmentStatus status,
        String notes,
        PatientDTO patient
) {
    public AppointmentDTO(Appointment entity) {
        this(entity.getId(), entity.getMoment(), entity.getStatus(), entity.getNotes(), entity.getPatient() != null ? new PatientDTO(entity.getPatient()) : null);
    }

}
