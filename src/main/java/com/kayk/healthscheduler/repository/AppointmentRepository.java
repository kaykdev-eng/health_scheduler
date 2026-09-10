package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndMoment(Long id, Instant moment);
}
