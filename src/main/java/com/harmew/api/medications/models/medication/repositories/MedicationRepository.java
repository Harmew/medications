package com.harmew.api.medications.models.medication.repositories;

import com.harmew.api.medications.models.medication.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    /**
     * Select all medications with status active = true
     */
    List<Medication> findAllByActiveTrue();
}
