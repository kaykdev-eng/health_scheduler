package com.kayk.healthscheduler.mapper;

import com.kayk.healthscheduler.DTO.SpecialityRequestDTO;
import com.kayk.healthscheduler.DTO.SpecialityResponseDTO;
import com.kayk.healthscheduler.entities.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    Speciality toEntity(SpecialityRequestDTO dto);
    SpecialityResponseDTO toDTO(Speciality entity);
    @Mapping(target = "id", ignore = true)
    void updateFromDto(SpecialityRequestDTO dto, @MappingTarget Speciality entity);
}
