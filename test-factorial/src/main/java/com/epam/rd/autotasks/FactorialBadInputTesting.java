package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testNullInput() {
        Factorial f = new Factorial();

        assertEquals(NumberFormatException.class, f.factorial(null));
    }

    @Test
    void testNegativeInput() {
        Factorial f = new Factorial();
  //      assertEquals();
    }

    @Test
    void testFractionalInput() {

    }

    @Test
    void testNonDigitalInput() {

    }


}
