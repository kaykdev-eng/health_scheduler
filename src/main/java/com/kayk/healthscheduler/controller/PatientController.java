package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.domain.patient.PatientRequestDTO;
import com.kayk.healthscheduler.domain.patient.PatientResponseDTO;
import com.kayk.healthscheduler.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> findAll() {
        List<PatientResponseDTO> pacientDTOS = patientService.findAll();
        return ResponseEntity.ok().body(pacientDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponseDTO> findById(@PathVariable UUID id) {
        PatientResponseDTO pacientDTO = patientService.findById(id);
        return ResponseEntity.ok().body(pacientDTO);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> insert(@Valid @RequestBody PatientRequestDTO entity) {
        PatientResponseDTO pacientDTO = patientService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pacientDTO.id()).toUri();
        return ResponseEntity.created(uri).body(pacientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable UUID id, @RequestBody PatientRequestDTO entity) {
        PatientResponseDTO patientResponseDTO = patientService.update(id, entity);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
