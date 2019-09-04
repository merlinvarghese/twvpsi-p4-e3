package com.tw.vapasi;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    @Nested
    class LengthTest {
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
    }
    @Nested
    class WeightTest {
        @Test
        void expect1KgEquals1000Gm() {
            Unit unit = Unit.KG;
            double actualOutput = unit.convertToBase(1);
            assertEquals(1000, actualOutput);
        }
    }

}
