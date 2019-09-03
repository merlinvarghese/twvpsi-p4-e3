package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(100, unit.convertToBase(1));

    }

    @Test
    void expect1KG1000GM()
    {
        Unit unit = Unit.KG;
        assertEquals( 1000,unit.convertToBase(1));
    }


}
