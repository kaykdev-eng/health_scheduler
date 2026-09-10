package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.DTO.PatientRequestDTO;
import com.kayk.healthscheduler.DTO.PatientResponseDTO;
import com.kayk.healthscheduler.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<PatientResponseDTO> findById(@PathVariable Long id) {
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
    public ResponseEntity<PatientResponseDTO> update(@PathVariable Long id, @RequestBody PatientRequestDTO entity) {
        PatientResponseDTO patientResponseDTO = patientService.update(id, entity);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
