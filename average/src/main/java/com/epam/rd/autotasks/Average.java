package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int avg;
        int temp=0;
        int count=0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }else{
                temp = temp+n;
                count++;
            }

        }
        avg=temp/count;
        System.out.println(avg);
    }

}