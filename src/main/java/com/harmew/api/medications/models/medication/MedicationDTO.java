package com.harmew.api.medications.models.medication;

import com.harmew.api.medications.models.medication.entities.Medication;
import com.harmew.api.medications.models.medication.enums.Laboratory;
import com.harmew.api.medications.models.medication.enums.Route;

import java.time.LocalDate;

public record MedicationDTO(
        Long id,
        String name,
        Route route,
        String batch,
        Laboratory laboratory,
        LocalDate expirationDate
) {

    public MedicationDTO(Medication medication) {
        this(
                medication.getId(),
                medication.getName(),
                medication.getRoute(),
                medication.getBatch(),
                medication.getLaboratory(),
                medication.getExpirationDate()
        );
    }
}
