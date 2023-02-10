package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    double a;
    double b;
    double c;
    double expected;


    public QuadraticEquationSingleRootCasesTesting(double a, double b, double c, double expected) {
    this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;


    }
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 1, -1},
                {4, 4, 1, -0.5},
                {1, -4, 4, 2},
                {-4, 28, -49, 3.5}
        });
    }
    @Test
    public void SingleRootCase() {
        assertEquals(expected + "", quadraticEquation.solve(a, b, c));
    }
}