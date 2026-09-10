package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.DTO.SpecialityRequestDTO;
import com.kayk.healthscheduler.DTO.SpecialityResponseDTO;
import com.kayk.healthscheduler.service.SpecialityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/specialties")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityResponseDTO>> findAll() {
        List<SpecialityResponseDTO> dtos = specialityService.findAll();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SpecialityResponseDTO> findById(@PathVariable Long id) {
        SpecialityResponseDTO dto = specialityService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<SpecialityResponseDTO> insert(@Valid @RequestBody SpecialityRequestDTO dto) {
        SpecialityResponseDTO specialityResponseDTO = specialityService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(specialityResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(specialityResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SpecialityResponseDTO> update(@PathVariable Long id, @RequestBody SpecialityRequestDTO dto) {
        SpecialityResponseDTO specialityResponseDTO = specialityService.update(id, dto);
        return ResponseEntity.ok().body(specialityResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        specialityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
