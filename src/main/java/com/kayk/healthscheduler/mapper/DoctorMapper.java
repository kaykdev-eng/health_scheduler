package com.kayk.healthscheduler.mapper;

import com.kayk.healthscheduler.DTO.DoctorRequestDTO;
import com.kayk.healthscheduler.DTO.DoctorResponseDTO;
import com.kayk.healthscheduler.entities.Doctor;
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
