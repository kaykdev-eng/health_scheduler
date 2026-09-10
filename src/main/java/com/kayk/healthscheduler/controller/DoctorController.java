package com.kayk.healthscheduler.controller;

import com.kayk.healthscheduler.DTO.DoctorRequestDTO;
import com.kayk.healthscheduler.DTO.DoctorResponseDTO;
import com.kayk.healthscheduler.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> findAll() {
        List<DoctorResponseDTO> doctorResponseDTOS = doctorService.findAll();
        return ResponseEntity.ok().body(doctorResponseDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorResponseDTO> findById(@PathVariable Long id) {
        DoctorResponseDTO doctorResponseDTO = doctorService.findById(id);
        return ResponseEntity.ok().body(doctorResponseDTO);
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> insert(@Valid @RequestBody DoctorRequestDTO dto) {
        DoctorResponseDTO doctorResponseDTO = doctorService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(doctorResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(doctorResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DoctorResponseDTO> update(@PathVariable Long id, @RequestBody DoctorRequestDTO dto) {
        DoctorResponseDTO doctorResponseDTO = doctorService.update(id, dto);
        return ResponseEntity.ok().body(doctorResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
