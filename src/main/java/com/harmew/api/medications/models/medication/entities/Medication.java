package com.harmew.api.medications.models.medication.entities;

import com.harmew.api.medications.models.medication.MedicationRegistrationDTO;
import com.harmew.api.medications.models.medication.enums.Laboratory;
import com.harmew.api.medications.models.medication.enums.Route;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "medication")
@Table(name = "tb_medication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medication implements Serializable {

    public Medication(MedicationRegistrationDTO data) {
        this.name = data.name();
        this.route = data.route();
        this.batch = data.batch();
        this.quantity = data.quantity();
        this.expirationDate = data.expirationDate();
        this.laboratory = data.laboratory();
        this.active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Route route;

    private String batch;
    private Integer quantity;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private Laboratory laboratory;

    private Boolean active;
}
