package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.DTO.SpecialityRequestDTO;
import com.kayk.healthscheduler.DTO.SpecialityResponseDTO;
import com.kayk.healthscheduler.entities.Speciality;
import com.kayk.healthscheduler.mapper.SpecialityMapper;
import com.kayk.healthscheduler.repository.SpecialityRepository;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private SpecialityMapper specialityMapper;

    @Transactional(readOnly = true)
    public List<SpecialityResponseDTO> findAll() {
       List<SpecialityResponseDTO> dtos = specialityRepository.findAll().stream().map(SpecialityResponseDTO::new).toList();
       return dtos;
    }

    @Transactional(readOnly = true)
    public SpecialityResponseDTO findById(Long id) {
       SpecialityResponseDTO dto = specialityRepository.findById(id).stream().map(SpecialityResponseDTO::new).findFirst().orElseThrow(() -> new ResourceNotFoundException(id));
       return dto;
    }

    @Transactional
    public SpecialityResponseDTO insert(SpecialityRequestDTO dto) {
        Speciality entity = specialityMapper.toEntity(dto);
        specialityRepository.save(entity);
        return new SpecialityResponseDTO(entity);
    }

    @Transactional
    public SpecialityResponseDTO update(Long id, SpecialityRequestDTO dto) {
        try {
            Speciality entity = specialityRepository.getReferenceById(id);
            specialityMapper.updateFromDto(dto, entity);
            specialityRepository.save(entity);
            return new SpecialityResponseDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional
    public void delete(Long id) {
        specialityRepository.deleteById(id);
    }
}
