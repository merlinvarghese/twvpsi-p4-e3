package com.tw.vapasi;

import java.util.Objects;

//Understand units of distance
class Distance {
    public static final int M_IN_CM = 100;
    public static final int KM_IN_CM = 100000;

    private final double value;
    private final Unit unit;

    //static factory method
    static Distance cm(double magnitude) {
        return new Distance(magnitude, Unit.CM);
    }

    static Distance km(double magnitude) {
        return new Distance(magnitude, Unit.KM);
    }

    static Distance meter(double magnitude) {
        return new Distance(magnitude, Unit.M);
    }

    enum Unit {
        KM,
        CM,
        M
    }

    Distance(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toCM() {
        switch (this.unit) {
            case M:
                return this.value * M_IN_CM;
            case KM:
                return this.value * KM_IN_CM;
            default:
                return this.value;
        }
    }

    @Override
    public boolean equals(Object otherDistance) {
        if (this == otherDistance) return true;

        if ((otherDistance == null) || (otherDistance.getClass() != this.getClass()))
            return false;

        Distance anotherMeasurement = (Distance) otherDistance;
        return this.toCM() == anotherMeasurement.toCM();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.unit);
    }

}
