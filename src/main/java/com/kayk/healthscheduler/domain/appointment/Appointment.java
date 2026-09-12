package com.kayk.healthscheduler.domain.appointment;

import com.kayk.healthscheduler.domain.doctor.Doctor;
import com.kayk.healthscheduler.domain.patient.Patient;
import com.kayk.healthscheduler.domain.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_appointment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Instant moment;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(UUID id, Instant moment, AppointmentStatus status, String notes) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.notes = notes;
    }
}
