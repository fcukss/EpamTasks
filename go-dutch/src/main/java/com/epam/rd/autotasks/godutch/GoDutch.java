package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int bill = scanner.nextInt();
            if (bill < 0) {
                System.out.println("Bill total amount cannot be negative");
                break;
            }

            int num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("Number of friends cannot be negative or zero");
                break;
            } else {
                int res = (int) ((bill + bill * 0.1) / num);
                System.out.println(res);

            }
        }
    }
}
