package com.kayk.healthscheduler.repository;

import com.kayk.healthscheduler.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Boolean existsByCrm(String crm);
}
