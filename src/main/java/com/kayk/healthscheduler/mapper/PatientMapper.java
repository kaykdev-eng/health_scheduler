package com.kayk.healthscheduler.mapper;

import com.kayk.healthscheduler.domain.patient.PatientRequestDTO;
import com.kayk.healthscheduler.domain.patient.PatientResponseDTO;
import com.kayk.healthscheduler.domain.patient.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientRequestDTO dto);
    PatientResponseDTO toDto(Patient entity);
    @Mapping(target = "id", ignore = true)
    void updateFromDto(PatientRequestDTO dto, @MappingTarget Patient entity);
}
