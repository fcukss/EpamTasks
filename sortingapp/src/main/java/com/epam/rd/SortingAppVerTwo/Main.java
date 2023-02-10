package com.epam.rd.SortingAppVerTwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * create Main class
 */
public class Main {

    /**
     * create arr with scanner in method
     *
     * @return
     */
    public int[] createArr() {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write five numbers");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return array;
    }

    /**
     * sort array by
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        if (array.length > 10)
            throw new IndexOutOfBoundsException();
        int count = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            boolean is_sorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    is_sorted = false;

                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
            if (is_sorted) {
                return array;
            }
        }
        return array;
    }

    /**
     * main thread
     *
     * @param args
     */
    public static void main(String[] args) {
        Main m = new Main();
        //  int[] res = m.sort(new int[]{9, 8, 5, 4,3});

        int[] res = m.sort(new int[]{9, 8, 5, 4, 3, 5, 6});

        System.out.println(Arrays.toString(res));
    }
}
