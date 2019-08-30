package com.tw.vapasi;

import org.junit.jupiter.api.Test;
import static com.tw.vapasi.Distance.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("ALL")
class DistanceTest {

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
        assertTrue(cm(100).equals(meter(1)));
    }

    @Test
    void expect1KMEquals1000M() {
        assertTrue(meter(1000).equals(km(1)));
    }

    @Test
    void expect1KMEquals100000CM() {
        assertTrue(cm(100000).equals(km(1)));
    }

    @Test
    void expect1KMNotEquals1000CM() {
        assertFalse(cm(1000).equals(km(1)));
    }
}