package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.DTO.PatientDTO;
import com.kayk.healthscheduler.entities.Patient;
import com.kayk.healthscheduler.repository.PatientRepository;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public PatientDTO insert(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.name());
        patient.setEmail(dto.email());
        patient.setPhone(dto.phone());
        patientRepository.save(patient);
        return new PatientDTO(patient);
    }

    @Transactional(readOnly = true)
    public PatientDTO findById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PatientDTO(patient);
    }

    @Transactional(readOnly = true)
    public List<PatientDTO> findAll() {
        List<PatientDTO> allPatients = patientRepository.findAll().stream().map(PatientDTO::new).toList();
        return allPatients;
    }

    @Transactional
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    public PatientDTO update(Long id, PatientDTO obj) {
        try {
            Patient patient = patientRepository.getReferenceById(id);
            updateData(patient, obj);
            patientRepository.save(patient);
            return new PatientDTO(patient);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Patient entity, PatientDTO patientDTO) {
        entity.setName(patientDTO.name());
        entity.setEmail(patientDTO.email());
        entity.setPhone(patientDTO.phone());
    }
}
