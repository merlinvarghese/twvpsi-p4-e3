package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Distance.cm;
import static com.tw.vapasi.Distance.km;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {

    @Test
    void expect1KM100000CM()
    {
       Unit unit = Unit.KM;
       double expected = unit.convertToBase(1);
       assertEquals( 100000,expected);
    }

    @Test
    void expect100CM1M()
    {
        Unit unit = Unit.M;

        double expected = unit.convertToBase(1);

        assertEquals(100, expected);

    }


}
