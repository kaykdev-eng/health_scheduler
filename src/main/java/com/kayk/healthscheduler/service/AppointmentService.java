package com.kayk.healthscheduler.service;

import com.kayk.healthscheduler.DTO.AppointmentDTO;
import com.kayk.healthscheduler.entities.Appointment;
import com.kayk.healthscheduler.entities.Patient;
import com.kayk.healthscheduler.repository.AppointmentRepository;
import com.kayk.healthscheduler.repository.PatientRepository;
import com.kayk.healthscheduler.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public AppointmentDTO insert(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setMoment(dto.moment());
        appointment.setStatus(dto.status());
        appointment.setNotes(dto.notes());

        Patient patient = patientRepository.getReferenceById(appointment.getPatient().getId());
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
        return new AppointmentDTO(appointment);
    }

    @Transactional(readOnly = true)
    public AppointmentDTO findById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new AppointmentDTO(appointment);
    }

    @Transactional(readOnly = true)
    public List<AppointmentDTO> findAll() {
        List<AppointmentDTO> allPatients = appointmentRepository.findAll().stream().map(AppointmentDTO::new).toList();
        return allPatients;
    }

    @Transactional
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Transactional
    public AppointmentDTO update(Long id, AppointmentDTO obj) {
        try {
            Appointment appointment = appointmentRepository.getReferenceById(id);
            updateData(appointment, obj);
            appointmentRepository.save(appointment);
            return new AppointmentDTO(appointment);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Appointment entity, AppointmentDTO appointmentDTO) {
        entity.setMoment(appointmentDTO.moment());
        entity.setStatus(appointmentDTO.status());
        entity.setNotes(appointmentDTO.notes());
    }
}
