package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        if (number == 0) {
            System.out.println("Oh, it looks like there is no one here");
        }
        if (number < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
sc.close();
Scanner sc2 =  new Scanner(System.in);
            //for (int i = 1; i <= number; i++){

            while (sc2.hasNext()) {
                sc2.useDelimiter(" ");
                String persons = sc2.nextLine();
                System.out.println("Hello, " + persons);

            }
        }
    }
}
