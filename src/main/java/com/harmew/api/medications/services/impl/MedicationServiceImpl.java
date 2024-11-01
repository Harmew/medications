package com.harmew.api.medications.services.impl;

import com.harmew.api.medications.models.medication.MedicationDTO;
import com.harmew.api.medications.models.medication.MedicationUpdateDTO;
import com.harmew.api.medications.models.medication.entities.Medication;
import com.harmew.api.medications.models.medication.repositories.MedicationRepository;
import com.harmew.api.medications.services.MedicationService;
import com.harmew.api.medications.services.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository repository;

    public MedicationServiceImpl(MedicationRepository medicationRepository) {
        this.repository = medicationRepository;
    }

    public List<MedicationDTO> findAllByActiveTrue() {
        return repository.findAllByActiveTrue().stream().map(MedicationDTO::new).toList();
    }

    public MedicationDTO findByIdActiveTrue(Long id) {
        try {
            Medication medication = repository.getReferenceById(id);
            return new MedicationDTO(medication);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public MedicationDTO saveMedication(Medication data) {
        Medication medication = repository.save(data);
        return new MedicationDTO(medication);
    }

    public MedicationDTO updateMedication(Long id, MedicationUpdateDTO data) {
        try {
            Medication medication = repository.getReferenceById(id);

            if (validateExists(data.name())) {
                medication.setName(data.name());
            }

            if (validateExists(data.route())) {
                medication.setRoute(data.route());
            }
            if (validateExists(data.laboratory())) {
                medication.setLaboratory(data.laboratory());
            }

            return new MedicationDTO(medication);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public void deleteMedication(Long id) {
        repository.deleteById(id);
    }

    public void inactivateMedication(Long id) {
        try {
            Medication medication = repository.getReferenceById(id);
            medication.setActive(false);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public void activateMedication(Long id) {
        try {
            Medication medication = repository.getReferenceById(id);
            medication.setActive(true);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    private boolean validateExists(Object param) {
        return param != null;
    }
}
