package com.bb.injurysurveillancesystem.dto.output;

import com.bb.injurysurveillancesystem.entity.Person;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.entity.enums.BodySide;
import com.bb.injurysurveillancesystem.entity.enums.Gender;

public class AthleteOutputDto extends Person {
    private Long id;
    private float height;
    private float weight;
    private float bmi;
    private float age;
    private Gender gender;
    private BodySide dominantSide;
    private PhysioEntity physiotherapist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
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

    public PhysioEntity getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(PhysioEntity physiotherapist) {
        this.physiotherapist = physiotherapist;
    }
}
