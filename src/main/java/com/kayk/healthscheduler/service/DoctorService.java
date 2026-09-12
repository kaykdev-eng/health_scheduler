package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.domain.doctor.DoctorRequestDTO;
import com.kayk.healthscheduler.domain.doctor.DoctorResponseDTO;
import com.kayk.healthscheduler.controller.exceptions.BusinessException;
import com.kayk.healthscheduler.domain.doctor.Doctor;
import com.kayk.healthscheduler.domain.speciality.Speciality;
import com.kayk.healthscheduler.mapper.DoctorMapper;
import com.kayk.healthscheduler.repository.DoctorRepository;
import com.kayk.healthscheduler.repository.SpecialityRepository;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Transactional(readOnly = true)
    public List<DoctorResponseDTO> findAll() {
        return doctorRepository.findAll().stream().map(DoctorResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public DoctorResponseDTO findById(UUID id) {
        return doctorRepository.findById(id).stream().map(DoctorResponseDTO::new).findFirst().orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public DoctorResponseDTO insert(DoctorRequestDTO dto) {
        if(doctorRepository.existsByCrm(dto.crm())) {
            throw new BusinessException("CRM number already registered in the database. CRM: " + dto.crm() ,HttpStatus.CONFLICT, "CRM_ALREADY_EXISTS");
        }

        Doctor doc = doctorMapper.toEntity(dto);
        Speciality speciality = specialityRepository.getReferenceById(dto.specialityId());
        doc.setSpeciality(speciality);

        doctorRepository.save(doc);
        return new DoctorResponseDTO(doc);
    }

    @Transactional
    public DoctorResponseDTO update(UUID id, DoctorRequestDTO dto) {
        try {
            Doctor doctor = doctorRepository.getReferenceById(id);
            doctorMapper.updateFromDto(dto, doctor);
            Speciality speciality = specialityRepository.getReferenceById(dto.specialityId());
            doctor.setSpeciality(speciality);
            doctorRepository.save(doctor);
            return new DoctorResponseDTO(doctor);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional
    public void delete(UUID id) {
        doctorRepository.deleteById(id);
    }
}
