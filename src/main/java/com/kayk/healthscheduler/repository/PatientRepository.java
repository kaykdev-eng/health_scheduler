package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByPhoneOrEmail(String phone,String email);
}
