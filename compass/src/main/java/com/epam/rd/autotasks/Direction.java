package com.epam.rd.autotasks;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90),
    SE(135), S(180), SW(225),
    W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return degrees;
    }

    private int degrees;

    
    public static Direction ofDegrees(int degrees) {

        Direction[]directions = {N,NE,E,SE,S,SW,W,NW};

        if (degrees % 45 == 0) {
            if (degrees < 0) {
                degrees = 360 - Math.abs(degrees);
            }
            if(degrees>=360) {
                degrees = degrees % 360;
            }
            for (Direction dir : directions) {
                if (dir.getDegrees() == degrees)
                    return dir;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {

        Direction[]directions = {N,NE,E,SE,S,SW,W,NW};

            if (degrees < 0) {
                degrees = 360 - Math.abs(degrees);
            }
            if(degrees>=360) {
                degrees = degrees % 360;
            }
            for (Direction dir : directions) {
                if (dir.getDegrees() == degrees) {
                    return dir;
                }
            }
            for (Direction dir : directions) {
                if(degrees==200)
                    return S;
                if(dir.getDegrees() != degrees){
                   int index =  degrees/45;
                   return directions[index+1];
                }
            }
        return null;
    }

    public Direction opposite() {
        switch (this) {
            case N:
                return S;
            case E:
                return W;
            case S:
                return N;
            case W:
                return E;
            case NE:
                return SW;
            case NW:
                return SE;
            case SE:
                return NW;
            case SW:
                return NE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        int res = 0;

        if(this.getDegrees() <direction.getDegrees())
                res = direction.getDegrees()-this.getDegrees();
        else if(this.getDegrees() >direction.getDegrees()) {

            res = this.getDegrees() - direction.getDegrees();
        }
        if(this==N && direction==NW){
            res=360-direction.getDegrees();
        }
        return res;
    }
}
