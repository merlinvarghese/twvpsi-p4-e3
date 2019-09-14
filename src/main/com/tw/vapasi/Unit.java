package com.tw.vapasi;

//understands standard of measurement
class Unit {
    private static final double MULTIPLIER_CM_METER = 100;
    private static final double MULTIPLIER_CM_KILOMETER = 100000;
    private static final double MULTIPLIER_GM_KG = 1000;
    static final Unit CM = new Unit(1, UnitType.LENGTH, 0);
    static final Unit M = new Unit(MULTIPLIER_CM_METER, UnitType.LENGTH, 0);
    static final Unit KM = new Unit(MULTIPLIER_CM_KILOMETER, UnitType.LENGTH, 0);
    static final Unit GM = new Unit(1, UnitType.WEIGHT, 0);
    static final Unit KG = new Unit(MULTIPLIER_GM_KG, UnitType.WEIGHT, 0);
    static final Unit C = new Unit(1, UnitType.TEMPERATURE, 0);
    static final Unit K = new Unit(1, UnitType.TEMPERATURE, 273.15);
    static final Unit F = new Unit(5.0 / 9, UnitType.TEMPERATURE, 32);

    private final double conversionFactor;
    private final UnitType type;
    private final double offsetValue;

    enum UnitType {
        LENGTH,
        WEIGHT,
        TEMPERATURE
    }

    private Unit(double conversionFactor, UnitType type, double offsetValue) {
        this.conversionFactor = conversionFactor;
        this.type = type;
        this.offsetValue = offsetValue;
    }

    double convertToBase(double magnitude) {
        return conversionFactor * (magnitude - offsetValue);
    }

    double convertTo(double magnitude, Unit otherUnit) {
        return magnitude * (this.conversionFactor / otherUnit.conversionFactor);
    }

    boolean isTypeCompatible(Unit other) {
        return this.type.equals(other.type);
    }
}