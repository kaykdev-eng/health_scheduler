package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.DTO.AppointmentDTO;
import com.kayk.healthscheduler.DTO.PatientDTO;
import com.kayk.healthscheduler.service.AppointmentService;
import com.kayk.healthscheduler.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        List<AppointmentDTO> appointmentDTOS = appointmentService.findAll();
        return ResponseEntity.ok().body(appointmentDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) {
        AppointmentDTO appointmentDTO = appointmentService.findById(id);
        return ResponseEntity.ok().body(appointmentDTO);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> insert(@RequestBody AppointmentDTO entity) {
        AppointmentDTO appointmentDTO = appointmentService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(appointmentDTO.id()).toUri();
        return ResponseEntity.created(uri).body(appointmentDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO entity) {
        AppointmentDTO appointmentDTO = appointmentService.update(id, entity);
        return ResponseEntity.ok().body(appointmentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
