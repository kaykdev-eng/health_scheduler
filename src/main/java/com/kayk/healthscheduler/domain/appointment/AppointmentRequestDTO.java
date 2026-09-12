package com.kayk.healthscheduler.domain.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kayk.healthscheduler.domain.enums.AppointmentStatus;

import java.time.Instant;
import java.util.UUID;

public record AppointmentRequestDTO(
        UUID id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment,
        AppointmentStatus status,
        String notes,
        UUID patientId,
        UUID doctorId
) {
}
