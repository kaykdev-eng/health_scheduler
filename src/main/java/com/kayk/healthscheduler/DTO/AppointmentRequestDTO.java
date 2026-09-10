package com.kayk.healthscheduler.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kayk.healthscheduler.entities.enums.AppointmentStatus;

import java.time.Instant;

public record AppointmentRequestDTO(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment,
        AppointmentStatus status,
        String notes,
        Long patientId,
        Long doctorId
) {
}
