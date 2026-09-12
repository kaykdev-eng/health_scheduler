package com.kayk.healthscheduler.domain.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kayk.healthscheduler.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_patient")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointmentList = new HashSet<>();


    public Patient(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
