package com.tw.vapasi;

import java.util.Objects;

//Understands quantification in various units
class Measurement {
    private final double magnitude;
    private final Unit unit;
    Measurement() {
        this.magnitude = 0;
        this.unit = Unit.CM;
    }
    private Measurement(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }
    static Measurement cm(double magnitude) {
        return new Measurement(magnitude, Unit.CM);
    }
    static Measurement km(double magnitude) {
        return new Measurement(magnitude, Unit.KM);
    }
    static Measurement meter(double magnitude) {
        return new Measurement(magnitude, Unit.M);
    }
    static Measurement kg(double magnitude) {
        return new Measurement(magnitude, Unit.KG);
    }
    static Measurement gm(double magnitude) {
        return new Measurement(magnitude, Unit.GM);
    }
    static Measurement celsius(double magnitude) {
        return new Measurement(magnitude, Unit.C);
    }
    static Measurement fahrenheit(double magnitude) {
        return new Measurement(magnitude, Unit.F);
    }

    Measurement add(Measurement other) throws CannotAddException {
        if(!this.unit.isTypeCompatible(other.unit))
            throw new CannotAddException();
/*        if(this.unit.isBaseUnit()){
           return new Measurement(this.magnitude + other.convertToBaseUnit(), this.unit);
       }*/
        double magnitudeOther = other.unit.convertTo(other.magnitude, this.unit);
        return new Measurement(this.magnitude + magnitudeOther, this.unit);
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
    private double convertToBaseUnit() {
        double a =unit.convertToBase(magnitude);
        return a;//unit.convertToBase(magnitude);
    }
}
