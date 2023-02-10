package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    double x1;
    double y1;


    private double radius;

    public Circle(Point center, double radius) {

        this.x1 = center.getX();

        this.y1 = center.getY();


        this.radius = radius;
    }

    @Override
    public double area() {

        double area = Math.PI*Math.pow(radius,2);

        return area;
    }

    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")";
    }

    @Override
    public Point leftmostPoint() {

        return new Point(x1-radius,y1);
    }
    @Override
    public String toString(){
      return   "Circle[(" + x1 + "," + y1 + ")" + radius + "]";
    }
}
