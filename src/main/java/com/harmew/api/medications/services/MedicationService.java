package com.harmew.api.medications.services;

import com.harmew.api.medications.models.medication.MedicationDTO;
import com.harmew.api.medications.models.medication.MedicationUpdateDTO;
import com.harmew.api.medications.models.medication.entities.Medication;

import java.util.List;

public interface MedicationService {

    /**
     * Returns a list of medication
     */
    List<MedicationDTO> findAllByActiveTrue();

    /**
     * Find By {Id}
     */
    MedicationDTO findByIdActiveTrue(Long id);

    /**
     * Saves a new medication in database
     */
    MedicationDTO saveMedication(Medication data);

    /**
     * Updates a specific medication
     */
    MedicationDTO updateMedication(Long id, MedicationUpdateDTO data);

    /**
     * Delete a specific medication
     */
    void deleteMedication(Long id);

    /**
     * Inactivate a specific medication
     */
    void inactivateMedication(Long id);

    /**
     * Active a specific inactivated medication
     */
    void activateMedication(Long id);
}
