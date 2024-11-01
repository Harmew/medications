package com.harmew.api.medications.models.medication;

import com.harmew.api.medications.models.medication.enums.Laboratory;
import com.harmew.api.medications.models.medication.enums.Route;

public record MedicationUpdateDTO(
        String name,
        Route route,
        Laboratory laboratory
) {

}
