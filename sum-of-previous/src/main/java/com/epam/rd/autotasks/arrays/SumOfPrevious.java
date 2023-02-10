package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] arr){
        boolean[] b=null;
        if (arr == null) {
            throw new UnsupportedOperationException();
        }
        if (arr != null) {
            b = new boolean[arr.length];
            b[0] = false;
            b[1] = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] + arr[i - 1] == arr[i + 1]) {
                    b[i + 1] = true;
                } else {
                    b[i + 1] = false;
                }
            }
        }
        return b;
    }
}
