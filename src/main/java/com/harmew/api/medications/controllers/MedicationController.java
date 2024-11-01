package com.harmew.api.medications.controllers;

import com.harmew.api.medications.models.medication.MedicationDTO;
import com.harmew.api.medications.models.medication.MedicationRegistrationDTO;
import com.harmew.api.medications.models.medication.MedicationUpdateDTO;
import com.harmew.api.medications.models.medication.entities.Medication;
import com.harmew.api.medications.services.MedicationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    private final MedicationService service;

    public MedicationController(MedicationService medicationService) {
        this.service = medicationService;
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> findAllByActiveTrue() {
        List<MedicationDTO> medications = service.findAllByActiveTrue();
        return ResponseEntity.ok(medications);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MedicationDTO> findByIdActiveTrue(@PathVariable Long id) {
        MedicationDTO medication = service.findByIdActiveTrue(id);
        return ResponseEntity.ok(medication);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MedicationDTO> saveMedication(@RequestBody @Valid MedicationRegistrationDTO data) {
        MedicationDTO medicationDTO = service.saveMedication(new Medication(data));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medicationDTO.id()).toUri();
        return ResponseEntity.created(uri).body(medicationDTO);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<MedicationDTO> updateMedication(@PathVariable Long id, @RequestBody @Valid MedicationUpdateDTO data) {
        MedicationDTO medication = service.updateMedication(id, data);
        return ResponseEntity.ok(medication);
    }

    @DeleteMapping("/inactivate/{id}")
    @Transactional
    public ResponseEntity<Void> inactivateMedication(@PathVariable Long id) {
        service.inactivateMedication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/activate/{id}")
    @Transactional
    public ResponseEntity<Void> activateMedication(@PathVariable Long id) {
        service.activateMedication(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }
}
