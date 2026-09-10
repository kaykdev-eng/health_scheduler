package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.DTO.PatientRequestDTO;
import com.kayk.healthscheduler.DTO.PatientResponseDTO;
import com.kayk.healthscheduler.entities.Patient;
import com.kayk.healthscheduler.mapper.PatientMapper;
import com.kayk.healthscheduler.repository.PatientRepository;
import com.kayk.healthscheduler.controller.exceptions.BusinessException;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Transactional
    public PatientResponseDTO insert(PatientRequestDTO dto) {
        Patient patient = patientMapper.toEntity(dto);
        boolean existsEmail = patientRepository.existsByPhoneOrEmail(patient.getPhone(), patient.getEmail());
        if(existsEmail) {
            throw new BusinessException("Data already exists in the database", HttpStatus.CONFLICT, "DATA_ALREADY_EXISTS");
        }
        patientRepository.save(patient);
        return new PatientResponseDTO(patient);
    }

    @Transactional(readOnly = true)
    public PatientResponseDTO findById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new PatientResponseDTO(patient);
    }

    @Transactional(readOnly = true)
    public List<PatientResponseDTO> findAll() {
        List<PatientResponseDTO> allPatients = patientRepository.findAll().stream().map(PatientResponseDTO::new).toList();
        return allPatients;
    }

    @Transactional
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    public PatientResponseDTO update(Long id, PatientRequestDTO obj) {
        try {
            Patient patient = patientRepository.getReferenceById(id);
            patientMapper.updateFromDto(obj, patient);
            patientRepository.save(patient);
            return new PatientResponseDTO(patient);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
