package com.bb.injurysurveillancesystem.dto.input;

import com.bb.injurysurveillancesystem.entity.Person;
import com.bb.injurysurveillancesystem.entity.enums.BodySide;
import com.bb.injurysurveillancesystem.entity.enums.Gender;

public class AthleteInputDto extends Person {
    private float height;
    private float weight;
    private int age;
    private Gender gender;
    private BodySide dominantSide;
    private Long physioId;

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

    public Long getPhysioId() {
        return physioId;
    }

    public void setPhysioId(Long physioId) {
        this.physioId = physioId;
    }
}
