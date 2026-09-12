package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.domain.appointment.AppointmentRequestDTO;
import com.kayk.healthscheduler.domain.appointment.AppointmentResponseDTO;
import com.kayk.healthscheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        List<AppointmentResponseDTO> appointmentDTOS = appointmentService.findAll();
        return ResponseEntity.ok().body(appointmentDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@PathVariable UUID id) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.findById(id);
        return ResponseEntity.ok().body(appointmentResponseDTO);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> insert(@RequestBody AppointmentRequestDTO entity) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(appointmentResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(appointmentResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable UUID id, @RequestBody AppointmentRequestDTO entity) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.update(id, entity);
        return ResponseEntity.ok().body(appointmentResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
