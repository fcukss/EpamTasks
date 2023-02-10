package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    double a;
    double b;
    double c;
    String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 5, -1, "-1.425390529679106 0.17539052967910607"},
                {5, -26, 5, "0.2 5.0"},
                {8, -6, 1, "0.25 0.5"},
                {7, 6, -1, "-1.0 0.14285714285714285"},
        });
    }
    @Test
    public void SingleRootCase() {
        assertEquals(expected + "", quadraticEquation.solve(a, b, c));
    }
}
