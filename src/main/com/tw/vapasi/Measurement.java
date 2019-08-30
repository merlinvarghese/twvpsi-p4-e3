package com.tw.vapasi;

import java.util.Objects;

//Understand units of distance
class Measurement {
    private static final String METER = "M";
    private static final String CENTIMETER = "CM";
    private static final String KILOMETER = "KM";

    private double value;
    private String unit;

    Measurement(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    Measurement toCentiMeter() {
        switch (this.unit) {
            case METER:
                return new Measurement(this.value * 100, CENTIMETER);
            case KILOMETER:
                return new Measurement(this.value * 100000, CENTIMETER);
        }
        return new Measurement(this.value / 100, METER);
    }

    @Override
    public boolean equals(Object otherMeasurement) {
        if (this == otherMeasurement) return true;

        if ((otherMeasurement == null) || (otherMeasurement.getClass() != this.getClass()))
            return false;

        Measurement anotherMeasurement = (Measurement) otherMeasurement;
        if (this.unit.compareTo(anotherMeasurement.unit) != 0)
            return false;

        return this.value == anotherMeasurement.value;

    }


    public int hashCode() {
        return Objects.hash(this.value, this.unit);
    }

}
