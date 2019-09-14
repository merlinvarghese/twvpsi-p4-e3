package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTest {
    @Test
    void expect20CMEquals20CM() {
        Unit unit = Unit.CM;
        double actualOutput = unit.convertToBase(20);
        assertEquals(20, actualOutput);
    }

    @Test
    void expect20MEquals2000CM() {
        Unit unit = Unit.M;
        double actualOutput = unit.convertToBase(20);
        assertEquals(2000, actualOutput);
    }

    @Test
    void expect20KMEquals200000CM() {
        Unit unit = Unit.KM;
        double actualOutput = unit.convertToBase(20);
        assertEquals(2000000, actualOutput);
    }

    @Test
    void expect1KgEquals1000Gm() {
        Unit unit = Unit.KG;
        double actualOutput = unit.convertToBase(1);
        assertEquals(1000, actualOutput);
    }

    @Test
    void expect0CentigradeEquals32F() {
        double celsius = 0.0;
        double fahrenheit = 32.0;
        assertEquals(0.0, Unit.C.convertToBase(celsius));
        assertEquals(0.0, Unit.F.convertToBase(fahrenheit));
    }

    @Test
    void expect1KelvinEqualsMinus272_15Celsius() {
        double kelvin = 1.0;
        double celsius = -271.15;
        assertEquals(-271.15, Unit.C.convertToBase(celsius));
        assertEquals(-272.15, Unit.K.convertToBase(kelvin));
    }
}
