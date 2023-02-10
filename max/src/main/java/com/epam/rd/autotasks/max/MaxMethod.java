package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] array) {
        int max = 0;
        if (array == null) {
            throw new UnsupportedOperationException();
        }
        if (array != null) {
            max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (max <= array[i])
                    max = array[i];
            }
        }
        return max;
    }
}


