package com.bb.injurysurveillancesystem.dto.output;

import com.bb.injurysurveillancesystem.entity.enums.BodySide;

public class BodyInfoOutputDto {
    private float height;
    private float weight;
    private float bmi;
    private BodySide dominantSide;
    private BodySide lowerExtremityDominantSide;
    private BodySide upperExtremityDominantSide;
    private float lowerExtremityLength;
    private float upperExtremityLength;

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
