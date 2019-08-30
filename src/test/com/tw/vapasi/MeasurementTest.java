package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class MeasurementTest {

    @Test
    void expectSameReferenceEqualsTrue() {
        Measurement kilometer1 = new Measurement(1, "KM");

        assertTrue(kilometer1.equals(kilometer1));
    }

    @Test
    void expectNullReferenceEqualsFalse() {
        Measurement kilometer1 = new Measurement(1, "KM");

        assertFalse(kilometer1.equals(null));
    }

    @Test
    void expectDifferentReferenceEqualsFalse() {
        Measurement kilometer1 = new Measurement(1, "KM");

        assertFalse(kilometer1.equals("tests"));
    }

    @Test
    void expectObjectsWithSameValueEqualsTrue() {
        Measurement kilometer = new Measurement(1, "KM");
        Measurement anotherKilometer = new Measurement(1, "KM");

        assertTrue(kilometer.equals(anotherKilometer));
    }

    @Test
    void expect100CMEquals1M() {
        Measurement centimeter100 = new Measurement(100, "CM");
        Measurement meter1 = new Measurement(1, "M");

        Measurement actual = meter1.toCentiMeter();

        assertTrue(centimeter100.equals(actual));
    }

    @Test
    void expect1KMEquals1000M() {
        Measurement kilometer1 = new Measurement(1, "KM");
        Measurement meter1000 = new Measurement(1000, "M");

        Measurement meterToCentimeter = meter1000.toCentiMeter();
        Measurement kilometerToCentimeter = kilometer1.toCentiMeter();

        assertTrue(meterToCentimeter.equals(kilometerToCentimeter));
    }

    @Test
    void expect1KMEquals100000CM() {
        Measurement kilometer1 = new Measurement(1, "KM");
        Measurement centimeter100000 = new Measurement(100000, "CM");

        Measurement kilometerToCentimeter = kilometer1.toCentiMeter();

        assertTrue(centimeter100000.equals(kilometerToCentimeter));
    }

    @Test
    void expect1KMNotEquals1000CM() {
        Measurement kilometer1 = new Measurement(1, "KM");
        Measurement centimeter1000 = new Measurement(1000, "CM");

        Measurement kilometerToCentimeter = kilometer1.toCentiMeter();

        assertFalse(centimeter1000.equals(kilometerToCentimeter));
    }
}