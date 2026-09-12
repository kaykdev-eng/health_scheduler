package com.kayk.healthscheduler.domain.speciality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kayk.healthscheduler.domain.doctor.Doctor;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_speciality")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Speciality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Doctor> doctors = new HashSet<>();


    public Speciality(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
