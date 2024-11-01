package com.harmew.api.medications.models.medication;

import com.harmew.api.medications.models.medication.enums.Route;
import com.harmew.api.medications.models.medication.enums.Laboratory;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record MedicationRegistrationDTO(
        @NotBlank
        String name,

        @Enumerated
        Route route,

        @NotBlank
        String batch,

        Integer quantity,

        @Future
        LocalDate expirationDate,

        @Enumerated
        Laboratory laboratory
) {

}
