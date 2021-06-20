package com.bb.injurysurveillancesystem.entity.enums;

public enum Sex {
    M("Male"),
    F("Female");

    private final String label;

    private Sex(String label) {
        this.label = label;
    }
}
