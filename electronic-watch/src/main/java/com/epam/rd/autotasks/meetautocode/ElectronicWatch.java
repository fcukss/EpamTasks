package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();


        int hour = seconds / 3600 % 24;
        int minut =seconds % 3600 / 60;
        int sec = seconds % 3600 % 60;

        System.out.printf("%d:%02d:%02d",hour,minut,sec);
    }
}
