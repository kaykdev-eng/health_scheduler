package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.DTO.PatientDTO;
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
    public ResponseEntity<List<PatientDTO>> findAll() {
        List<PatientDTO> pacientDTOS = patientService.findAll();
        return ResponseEntity.ok().body(pacientDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) {
        PatientDTO pacientDTO = patientService.findById(id);
        return ResponseEntity.ok().body(pacientDTO);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> insert(@Valid @RequestBody PatientDTO entity) {
        PatientDTO pacientDTO = patientService.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(pacientDTO.id()).toUri();
        return ResponseEntity.created(uri).body(pacientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO entity) {
        PatientDTO patientDTO = patientService.update(id, entity);
        return ResponseEntity.ok().body(patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
