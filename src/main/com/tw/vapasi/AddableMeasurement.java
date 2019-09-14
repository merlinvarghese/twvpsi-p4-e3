package com.tw.vapasi;

//Understands quantification in various units that can be added
class AddableMeasurement extends Measurement {
    private static final String CANNOT_ADD_TEXT = "Cannot perform addition on different unit types";

    private AddableMeasurement(double magnitude, Unit unit) {
        super(magnitude, unit);
    }

    static AddableMeasurement cm(double magnitude) {
        return new AddableMeasurement(magnitude, Unit.CM);
    }

    static AddableMeasurement km(double magnitude) {
        return new AddableMeasurement(magnitude, Unit.KM);
    }

    static AddableMeasurement meter(double magnitude) {
        return new AddableMeasurement(magnitude, Unit.M);
    }

    static AddableMeasurement kg(double magnitude) {
        return new AddableMeasurement(magnitude, Unit.KG);
    }

    static AddableMeasurement gm(double magnitude) {
        return new AddableMeasurement(magnitude, Unit.GM);
    }

    Measurement add(Measurement other) throws CannotAddException {
        if (!this.unit.isTypeCompatible(other.unit))
            throw new CannotAddException(CANNOT_ADD_TEXT);
        double magnitudeOther = other.unit.convertTo(other.magnitude, this.unit);
        return new AddableMeasurement(this.magnitude + magnitudeOther, this.unit);
    }
}
