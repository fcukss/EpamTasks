package com.epam.rd.autotasks.figures;

import java.util.Arrays;


class Quadrilateral extends Figure {

    double x1;
    double x2;
    double x3;
    double x4;
    double y1;
    double y2;
    double y3;
    double y4;


    public Quadrilateral(Point a, Point b, Point c, Point d) {

        this.x1 = a.getX();
        this.x2 = b.getX();
        this.x3 = c.getX();
        this.x4 = d.getX();
        this.y1 = a.getY();
        this.y2 = b.getY();
        this.y3 = c.getY();
        this.y4 = d.getY();
    }


    @Override
    public double area() {

        double area = (Math.abs((x1 - x2) * (y1 + y2) + (x2 - x3) * (y2 + y3) + (x3 - x4) * (y3 + y4) + (x4 - x1) * (y4 + y1))) / 2d;
        return area;
    }

    @Override
    public String pointsToString() {

        return "(" + x1 + "," + y1 + ")" +
                "(" + x2 + "," + y2 + ")" +
                "(" + x3 + "," + y3 + ")" +
                "(" + x4 + "," + y4 + ")";
    }

    @Override
    public Point leftmostPoint() {

        double[] points = {x1,x2,x3,x4};
        Arrays.sort(points);

        double x = points[0];


        if(x1 == x)
                return new Point(x1, y1);
        if(x2 == x)
                return new Point(x2, y2);
        if(x3 == x)
                return new Point(x3, y3);
        if(x4 == x)
                return new Point(x4, y4);
   else
return null;
    }

    @Override
    public String toString() {

        return "Quadrilateral[(" + x1 + "," + y1 + ")" +
                "(" + x2 + "," + y2 + ")" +
                "(" + x3 + "," + y3 + ")" +
                "(" + x4 + "," + y4 + ")]";
    }
}

