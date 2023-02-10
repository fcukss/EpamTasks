package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array.length==0){
            array=array;
        }
        if(array.length>0) {
            int[] arr2 = new int[array.length];
            int shift = 4;
            int[] copy = Arrays.copyOf(array, shift);
            System.arraycopy(array, shift, array, 0, array.length - shift);
            System.arraycopy(copy, 0, array, array.length - shift, shift);
        }
        }

    static void cycleSwap(int[] array, int shift) {

        if(array.length==0){
           array=array;
        }
        if(shift== array.length){
            array=array;
        }

        if(array.length>0 && shift!= array.length) {
            int[] arr2 = new int[array.length];
             shift += 1;
            int[] copy = Arrays.copyOf(array, shift);
            System.arraycopy(array, shift, array, 0, array.length - shift);
            System.arraycopy(copy, 0, array, array.length - shift, shift);
        }
    }
}
