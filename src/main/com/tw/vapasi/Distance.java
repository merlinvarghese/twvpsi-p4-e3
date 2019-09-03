package com.tw.vapasi;

import java.util.Objects;

//Understand units of distance
class Distance {
    private static final int M_IN_CM = 100;
    private static final int KM_IN_CM = 100000;

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

    private Distance(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object otherDistance) {
        if (this == otherDistance) return true;

        if ((otherDistance == null) || (otherDistance.getClass() != this.getClass()))
            return false;

        Distance other = (Distance)otherDistance;
        return this.unit.convertToBase(value) == other.unit.convertToBase(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

}
