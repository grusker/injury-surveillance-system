package com.bb.injurysurveillancesystem.entity;

import com.bb.injurysurveillancesystem.entity.enums.BodySide;
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
    @Column(columnDefinition = "NUMBER(4,1)")
    private float height;
    @Column(columnDefinition = "NUMBER(4,1)")
    private float weight;
    @Column(columnDefinition = "NUMBER(10,3)")
    private float bmi;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private BodySide dominantSide;
    @ManyToOne
    @JoinColumn(name = "physio_id", nullable = true)
    private PhysioEntity physioterapist;


    public Long getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        setBmi();
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
        setBmi();
    }

    public float getBmi() {
        return this.bmi;
    }

    private void setBmi() {
        if(getWeight()>0 && getHeight()>0) {
            this.bmi = getWeight() / ((getHeight()/100) * (getHeight()/100));
        } else {
            this.bmi = 0;
        }
    }

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

    public BodySide getDominantSide() {
        return dominantSide;
    }

    public void setDominantSide(BodySide dominantSide) {
        this.dominantSide = dominantSide;
    }

    public PhysioEntity getPhysioterapist() {
        return physioterapist;
    }

    public void setPhysioterapist(PhysioEntity physioterapist) {
        this.physioterapist = physioterapist;
    }
}
