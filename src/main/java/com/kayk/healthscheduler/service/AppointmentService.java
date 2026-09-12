package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.domain.appointment.AppointmentResponseDTO;
import com.kayk.healthscheduler.domain.appointment.AppointmentRequestDTO;
import com.kayk.healthscheduler.domain.appointment.Appointment;
import com.kayk.healthscheduler.domain.doctor.Doctor;
import com.kayk.healthscheduler.domain.patient.Patient;
import com.kayk.healthscheduler.mapper.AppointmentMapper;
import com.kayk.healthscheduler.repository.AppointmentRepository;
import com.kayk.healthscheduler.repository.DoctorRepository;
import com.kayk.healthscheduler.repository.PatientRepository;
import com.kayk.healthscheduler.controller.exceptions.BusinessException;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Transactional
    public AppointmentResponseDTO insert(AppointmentRequestDTO dto) {
        Appointment appointment = appointmentMapper.toEntity(dto);

        Patient patient = patientRepository.getReferenceById(dto.patientId());
        appointment.setPatient(patient);

        Doctor doctor = doctorRepository.getReferenceById(dto.doctorId());
        appointment.setDoctor(doctor);

        boolean hasScheduleConflict = appointmentRepository.existsByDoctorIdAndMoment(doctor.getId(), appointment.getMoment());
        if(hasScheduleConflict) {
            throw new BusinessException("The doctor already has an appointment scheduled for the same time.", HttpStatus.CONFLICT, "APPOINTMENT_ALREADY_EXISTS");
        }

        appointmentRepository.save(appointment);
        return new AppointmentResponseDTO(appointment);
    }

    @Transactional(readOnly = true)
    public AppointmentResponseDTO findById(UUID id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new AppointmentResponseDTO(appointment);
    }

    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> findAll() {
        List<AppointmentResponseDTO> allPatients = appointmentRepository.findAll().stream().map(AppointmentResponseDTO::new).toList();
        return allPatients;
    }

    @Transactional
    public void delete(UUID id) {
        appointmentRepository.deleteById(id);
    }

    @Transactional
    public AppointmentResponseDTO update(UUID id, AppointmentRequestDTO obj) {
        try {
            Appointment appointment = appointmentRepository.getReferenceById(id);
            appointmentMapper.updateFromDto(obj, appointment);

            if(obj.patientId() != null ) {
                Patient patient = patientRepository.getReferenceById(obj.id());
                appointment.setPatient(patient);
            }

            if(obj.doctorId() != null ) {
                Doctor doctor = doctorRepository.getReferenceById(obj.id());
                appointment.setDoctor(doctor);
            }

            appointmentRepository.save(appointment);
            return new AppointmentResponseDTO(appointment);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
