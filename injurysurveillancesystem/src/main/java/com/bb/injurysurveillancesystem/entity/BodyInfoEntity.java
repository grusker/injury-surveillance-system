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
    @Column(columnDefinition = "NUMERIC(4,1)")
    private float height;
    @Column(columnDefinition = "NUMERIC(4,1)")
    private float weight;
    @Column(columnDefinition = "NUMERIC(10,3)")
    private float bmi;
    @Enumerated(EnumType.STRING)
    private BodySide dominantSide;

    private BodySide lowerExtremityDominantSide;
    private BodySide upperExtremityDominantSide;
    private float lowerExtremityLength;
    private float upperExtremityLength;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

    public BodySide getLowerExtremityDominantSide() {
        return lowerExtremityDominantSide;
    }

    public void setLowerExtremityDominantSide(BodySide lowerExtremityDominantSide) {
        this.lowerExtremityDominantSide = lowerExtremityDominantSide;
    }

    public BodySide getUpperExtremityDominantSide() {
        return upperExtremityDominantSide;
    }

    public void setUpperExtremityDominantSide(BodySide upperExtremityDominantSide) {
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
