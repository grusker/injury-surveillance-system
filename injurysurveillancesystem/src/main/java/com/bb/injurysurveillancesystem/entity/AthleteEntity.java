package com.bb.injurysurveillancesystem.entity;

import com.bb.injurysurveillancesystem.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "athlete")
public class AthleteEntity extends Person{
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "physio_id", nullable = true)
    private PhysioEntity physiotherapist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PhysioEntity getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(PhysioEntity physiotherapist) {
        this.physiotherapist = physiotherapist;
    }
}
