package com.epam.rd.autotasks;

import java.util.Arrays;

public class Sorting {
    public void sort(int[] array){
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
            if(is_sorted){
                return;
            }
        }
    }
}
