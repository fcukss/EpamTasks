package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int piece = sc.nextInt();
        sc.close();
        if (piece == n) {
            System.out.println(1);
        }
        if (piece == 1) {
            System.out.println(n);
        }
        if (piece > n || piece < n && piece != 1) {
            int count = 1;
            int expr = 1;
            expr = piece % n;
            while (expr != 0) {
                count++;
                piece = piece * count;
                expr = piece % n;
            }

            System.out.println(count);
        }

    }
}
