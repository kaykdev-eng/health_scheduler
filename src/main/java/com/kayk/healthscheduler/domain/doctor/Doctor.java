package com.kayk.healthscheduler.domain.doctor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kayk.healthscheduler.domain.speciality.Speciality;
import com.kayk.healthscheduler.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_doctor")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String crm;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Doctor(UUID id, String name, String crm, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.price = price;
    }
}
