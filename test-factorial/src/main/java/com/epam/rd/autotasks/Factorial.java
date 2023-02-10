package com.epam.rd.autotasks;

public class Factorial {
    public String factorial(String n) {
        if (n == null) {
            throw new NumberFormatException();
        }
        int x = Integer.parseInt(n);
        return fact(x) + "";
    }

    public static int fact(int x) {
        if (x == 1)
            return 1;
        else if (x < 0)
            return fact(x+1);
         else{
            return x * fact(x - 1);
        }
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        String s = "-5";
        System.out.println(f.factorial(s));
    }
}
