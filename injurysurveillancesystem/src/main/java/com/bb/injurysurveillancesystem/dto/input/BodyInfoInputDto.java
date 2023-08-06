package com.bb.injurysurveillancesystem.dto.input;

import com.bb.injurysurveillancesystem.entity.enums.BodySide;

public class BodyInfoInputDto {
    private float height;
    private float weight;
    private BodySide dominantSide;
    private float lowerExtremityDominantSide;
    private float upperExtremityDominantSide;
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