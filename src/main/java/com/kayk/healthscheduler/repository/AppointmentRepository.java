package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.domain.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    boolean existsByDoctorIdAndMoment(UUID id, Instant moment);
}
