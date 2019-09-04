package com.tw.vapasi;

import java.util.Objects;

//Understand various measurement units
class Measurement {

    private final double value;
    private final Unit unit;
    private final Type type;

    enum Type {
        WEIGHT,
        LENGTH
    }

    private Measurement(double value, Unit unit, Type type) {
        this.value = value;
        this.unit = unit;
        this.type = type;
    }

    static Measurement cm(double magnitude) {
        return new Measurement(magnitude, Unit.CM, Type.LENGTH);
    }

    static Measurement km(double magnitude) {
        return new Measurement(magnitude, Unit.KM, Type.LENGTH);
    }

    static Measurement m(double magnitude) {
        return new Measurement(magnitude, Unit.M, Type.LENGTH);
    }

    static Measurement kg(double magnitude) {
        return new Measurement(magnitude, Unit.KG, Type.WEIGHT);
    }

    static Measurement gm(double magnitude) {
        return new Measurement(magnitude, Unit.GM, Type.WEIGHT);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other == null) || (this.getClass() != other.getClass())) {
            return false;
        }
        Measurement otherMeasurement = (Measurement) other;
        if (isDifferentType(otherMeasurement)) {
            return false;
        }
        return this.unit.convertToBase(this.value) == otherMeasurement.unit.convertToBase(otherMeasurement.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.hashCode(), this.value);
    }

    private boolean isDifferentType(Measurement other) {
        return !this.type.equals(other.type);
    }

    double add(Measurement measurementOther) throws CannotAddException {

        if (isDifferentType(measurementOther))
            throw new CannotAddException();
        return this.unit.convertToBase(this.value) + measurementOther.unit.convertToBase(measurementOther.value);

    }


}
