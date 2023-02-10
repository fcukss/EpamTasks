package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] arr){

        int[] result = new int[arr.length];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((i > 0 && arr[i] <= arr[i - 1])
                    || (i != arr.length - 1 && arr[i] <= arr[i + 1])){
                result[j++] = arr[i];
            }
        }
        return Arrays.copyOf(result, j);
    }
}
