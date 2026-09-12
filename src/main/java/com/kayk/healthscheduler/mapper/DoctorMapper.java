package com.kayk.healthscheduler.mapper;

import com.kayk.healthscheduler.domain.doctor.DoctorRequestDTO;
import com.kayk.healthscheduler.domain.doctor.DoctorResponseDTO;
import com.kayk.healthscheduler.domain.doctor.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorRequestDTO dto);
    DoctorResponseDTO toDto(Doctor entity);
    @Mapping(target = "id", ignore = true)
    void updateFromDto(DoctorRequestDTO dto, @MappingTarget Doctor entity);
}
