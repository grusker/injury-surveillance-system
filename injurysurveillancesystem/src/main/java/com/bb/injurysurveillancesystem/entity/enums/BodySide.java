package com.bb.injurysurveillancesystem.entity.enums;

public enum BodySide {
    L("LEFT"),
    R("RIGHT");

    private final String label;

    private BodySide(String label) {
        this.label = label;
    }
}
