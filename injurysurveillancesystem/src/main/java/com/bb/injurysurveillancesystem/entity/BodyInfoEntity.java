package com.bb.injurysurveillancesystem.entity;

import com.bb.injurysurveillancesystem.entity.enums.BodySide;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "bodyInfo")
public class BodyInfoEntity {
    @Id
    @JsonIgnore
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private AthleteEntity athlete;
    @Column(columnDefinition = "NUMBER(4,1)")
    private float height;
    @Column(columnDefinition = "NUMBER(4,1)")
    private float weight;
    @Column(columnDefinition = "NUMBER(10,3)")
    private float bmi;
    @Enumerated(EnumType.STRING)
    private BodySide dominantSide;

    private float lowerExtremityDominantSide;
    private float upperExtremityDominantSide;
    private float lowerExtremityLength;
    private float upperExtremityLength;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AthleteEntity getAthlete() {
        return athlete;
    }

    public void setAthlete(AthleteEntity athlete) {
        this.athlete = athlete;
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

    public BodySide getDominantSide() {
        return dominantSide;
    }

    public void setDominantSide(BodySide dominantSide) {
        this.dominantSide = dominantSide;
    }

    public float getLowerExtremityDominantSide() {
        return lowerExtremityDominantSide;
    }

    public void setLowerExtremityDominantSide(float lowerExtremityDominantSide) {
        this.lowerExtremityDominantSide = lowerExtremityDominantSide;
    }

    public float getUpperExtremityDominantSide() {
        return upperExtremityDominantSide;
    }

    public void setUpperExtremityDominantSide(float upperExtremityDominantSide) {
        this.upperExtremityDominantSide = upperExtremityDominantSide;
    }

    public float getLowerExtremityLength() {
        return lowerExtremityLength;
    }

    public void setLowerExtremityLength(float lowerExtremityLength) {
        this.lowerExtremityLength = lowerExtremityLength;
    }

    public float getUpperExtremityLength() {
        return upperExtremityLength;
    }

    public void setUpperExtremityLength(float upperExtremityLength) {
        this.upperExtremityLength = upperExtremityLength;
    }
}
