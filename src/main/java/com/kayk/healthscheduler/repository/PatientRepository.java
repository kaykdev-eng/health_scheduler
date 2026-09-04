package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
