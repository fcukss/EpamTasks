package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if (a <= b && a<h) {
            System.out.println("Impossible");
        } else {
            if(a>=h){
                System.out.println("1");
            }else {
                int res = 0;
                int count = 0;
                do {
                    res = h - a + b;
                    h = res;
                    count++;
                } while (h >= a);
                System.out.println(count);
            }
        }
    }
}

