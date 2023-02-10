package com.epam.rd.autotasks;

public class QuadraticEquation {
    public String solve(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException();
        }

        double x1;
        double x2;
        double D = b * b - 4d * a * c;
        if (D == 0) {
            x1 = -b / 2d * a;
            return Double.toString(x1);
        } else if (D > 0) {
            x1 = (-b + Math.sqrt(D)) / (2d * a);
            x2 = (-b - Math.sqrt(D)) / (2d * a);
           return x1 + " " + x2;
        }
        return "no roots";
    }
}