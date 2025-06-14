package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GroceryCounterTest {

    @Test
    void defaultCounterValueIsZero() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("0000", counter.counter);
    }

    @Test
    void customCounterValueConstructorWorks() {
        GroceryCounter counter = new GroceryCounter("5555");
        assertEquals("5555", counter.counter);
    }

    @Test
    void customMaxValueConstructorWorks() {
        GroceryCounter counter = new GroceryCounter(99999);
        assertEquals(99999, counter.max);
    }

    @Test
    void addTensToDefaultCounteris1000() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens();
        assertEquals("1000", counter.counter);
    }

    @Test
    void addOnesToDefaultCounteris0100() {
        GroceryCounter counter = new GroceryCounter();
        counter.ones();
        assertEquals("0100", counter.counter);
    }

    @Test
    void addTenthsToDefaultCounteris0010() {
        GroceryCounter counter = new GroceryCounter();
        counter.tenths();
        assertEquals("0010", counter.counter);
    }

    @Test
    void addHundrethsToDefaultCounteris0001() {
        GroceryCounter counter = new GroceryCounter();
        counter.hundreths();
        assertEquals("0001", counter.counter);
    }

    @Test
    void defaultValuedCounterTotalWorks() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());

        GroceryCounter counter1 = new GroceryCounter("5252");
        assertEquals("$52.52", counter1.total());
    }

    @Test
    void overflowCounteris1WhenOverflows() {
        GroceryCounter counter = new GroceryCounter("9999");
        counter.hundreths();
        assertEquals(1, counter.overflows());

        GroceryCounter counter1 = new GroceryCounter("9999");
        counter1.tenths();
        assertEquals(1, counter1.overflows());

        GroceryCounter counter2 = new GroceryCounter("9999");
        counter2.ones();
        assertEquals(1, counter2.overflows());

        GroceryCounter counter3 = new GroceryCounter("9999");
        counter3.tens();
        assertEquals(1, counter3.overflows());

        GroceryCounter counter4 = new GroceryCounter("9999");
        for (int i = 0; i < 11; i++) {
            counter4.tens();
        }
        assertEquals(2, counter4.overflows());
    }

    @Test
    void clearCounterShouldClearTheCounterAndOverflowcounter() {
        GroceryCounter counter = new GroceryCounter("9999");
        counter.hundreths();
        assertEquals(1, counter.overflows());
        assertEquals("0000", counter.counter);

        counter.clear();
        assertEquals(0, counter.overflows());
        assertEquals("0000", counter.counter);
    }

    @Test
    void IsoverflowFunctionalityWorksWell() {
        GroceryCounter counter = new GroceryCounter("9999");
        counter.hundreths();

        assertEquals(1, counter.overflows());
        assertEquals("0000", counter.counter);
        counter.clear();
        assertEquals(0, counter.overflows());
        assertEquals("0000", counter.counter);

        counter.increment(10000);
        assertEquals(1, counter.overflows());
        assertEquals("0000", counter.counter);

        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        assertEquals(2, counter.overflows());
        assertEquals("0000", counter.counter);
    }

    @Test
    void decrementTensFromZeroWrapsToMax() {
        GroceryCounter counter = new GroceryCounter("0000");
        counter.decrementTens();
        assertEquals("9999", counter.counter);
        assertEquals(1, counter.overflows());
    }
}
