package com.tw.vapasi;

import java.util.Objects;

//Understands quantification in various units
class Measurement {
    protected final double magnitude;
    protected final Unit unit;

    protected Measurement(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    static Measurement centigrade(double magnitude) {
        return new Measurement(magnitude, Unit.C);
    }

    static Measurement fahrenheit(double magnitude) {
        return new Measurement(magnitude, Unit.F);
    }

    static Measurement kelvin(double magnitude) {
        return new Measurement(magnitude, Unit.K);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement other = (Measurement) o;
        if (!this.unit.isTypeCompatible(other.unit)) {
            return false;
        }
        return convertToBaseUnit() == other.convertToBaseUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit.hashCode());
    }

    @Override
    public String toString() {
        return "" + this.magnitude + ":" + this.unit;
    }

    private double convertToBaseUnit() {
        return unit.convertToBase(magnitude);
    }

}

