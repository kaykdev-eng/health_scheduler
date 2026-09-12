package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByPhoneOrEmail(String phone,String email);
}
