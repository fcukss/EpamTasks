package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationZeroACasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    double a;
    double b;
    double c;
    public QuadraticEquationZeroACasesTesting(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, -1, -1},
                {0, 10, 7},
                {0, 4, 8},
                {0, -2, 3}
        });
    }
    @Test(expected = IllegalArgumentException.class)
    public void SingleRootCase() {
         quadraticEquation.solve(a, b, c);
    }
}
