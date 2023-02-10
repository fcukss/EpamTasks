package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {


        int max = 0;
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if(max<n){
                max=n;
            }
        }
     //   System.out.println(max);
        return max;
    //    return 0;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
