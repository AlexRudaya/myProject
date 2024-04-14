package com.aston.Lesson_7;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void positiveNumbers() {
        Factorial positive = new Factorial();
        assertAll(
                () -> assertEquals(120, positive.getFactorial(5)),
                () -> assertEquals(1, positive.getFactorial(1)),
                () -> assertEquals(1, positive.getFactorial(0)),
                () -> assertEquals(738197504, positive.getFactorial(31))
        );
    }

    @Test
    public void negativeNumbers() {
        Factorial negative = new Factorial();
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> negative.getFactorial(-8)
        );
        assertEquals("Number can't be negative", thrown.getMessage());
    }

    @Test
    public void outOfBoundary() {
        Factorial boundaryValues = new Factorial();
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> boundaryValues.getFactorial(32)
        );
        assertEquals("Result is outOfBound", thrown.getMessage());
    }


}