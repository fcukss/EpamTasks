package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure{
    double x1;
    double x2;
    double x3;
    double y1;
    double y2;
    double y3;

    public Triangle(Point a, Point b, Point c) {
        this.x1 = a.getX();
        this.x2 = b.getX();
        this.x3 = c.getX();
        this.y1 = a.getY();
        this.y2 = b.getY();
        this.y3 = c.getY();

    }

    @Override
    public double area() {
        return Math.abs(0.5 * ((x3 - x1) * (y2 - y1) -
                (y3 - y1) * (x2 - x1)));

    }

    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")" +
                "(" + x2 + "," + y2 + ")" +
                "(" + x3 + "," + y3 + ")";

    }

    @Override
    public Point leftmostPoint() {

        double[] points = {x1,x2,x3};
        Arrays.sort(points);

        double x = points[0];


        if(x1 == x)
            return new Point(x1, y1);
        if(x2 == x)
            return new Point(x2, y2);
        if(x3 == x)
            return new Point(x3, y3);
        else
            return null;
    }
}

