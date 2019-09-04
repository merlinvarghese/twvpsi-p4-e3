package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.tw.vapasi.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings(value = "ALL")
class MeasurementTest {

    @Test
    void expectSameReferenceEqualsTrue() {
        assertTrue(km(1).equals(km(1)));

    }

    @Test
    void expectNullReferenceEqualsFalse() {
        assertFalse(km(1).equals(null));
    }

    @Test
    void expectDifferentReferenceEqualsFalse() {
        assertFalse(km(1).equals("tests"));
    }

    @Test
    void expect100CmEquals100Cm() {
        assertTrue(cm(100).equals(cm(100)));
    }

    @Test
    void expect100CMEquals1M() {
        assertTrue(cm(100).equals(m(1)));
    }

    @Test
    void expect1KMEquals1000M() {
        assertTrue(m(1000).equals(km(1)));
    }

    @Test
    void expect1KMEquals100000CM() {
        assertTrue(cm(100000).equals(km(1)));
    }

    @Test
    void expect1KMNotEquals1000CM() {
        assertFalse(cm(1000).equals(km(1)));
    }

    @Test
    void expect1KgEquals1000Gms() {
        assertTrue(kg(1).equals(gm(1000)));
    }

    @Test
    void expect1KGNotEquals1000M(){
        assertFalse(kg(1).equals(m(1000)));
    }

    @Test
    void expect200CWhenAdding100CMAnd2M() throws CannotAddException{
        assertEquals(300, cm(100).add(m(2)));

    }

    @Test
    void expectDoesNotAllowOfAdditionOfDifferentTypes()
    {
        Measurement kg1 = kg(1);
        Measurement m100 = m(100);

        try
        {
            kg(1).add(m100);
            Assertions.fail("It has thrown an exception");
        }
        catch (CannotAddException e)
        {


        }
    }

    @Test
    void expect2_2KGWhenAdding2KGAnd200GM() throws CannotAddException
    {
        assertEquals(2.2, kg(2).add(gm(200)));
    }




}