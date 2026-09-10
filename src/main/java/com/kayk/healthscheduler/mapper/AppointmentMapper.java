package com.kayk.healthscheduler.mapper;

import com.kayk.healthscheduler.DTO.AppointmentResponseDTO;
import com.kayk.healthscheduler.DTO.AppointmentRequestDTO;
import com.kayk.healthscheduler.entities.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Appointment toEntity(AppointmentRequestDTO dto);

    AppointmentResponseDTO toDto(Appointment entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    void updateFromDto(AppointmentRequestDTO dto, @MappingTarget Appointment entity);
}
