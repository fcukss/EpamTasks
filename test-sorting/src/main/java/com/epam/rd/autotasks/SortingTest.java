package com.epam.rd.autotasks;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SortingTest {

    Sorting sorting = new Sorting();

    @Test (expected = NullPointerException.class)
    public void testNullCase(){
        int[]array = null;
        sorting.sort(array);
    }

    @Test
    public void testEmptyCase(){
int[] emptyarray = {};
        int[] emptyArray = {};
        sorting.sort(emptyArray);
        assertArrayEquals(emptyArray, emptyarray);
    }

    @Test
    public void testSingleElementArrayCase() {
        int[] expectedSingle = new int[]{7};
        int[] singleElementArray = new int[]{7};
        sorting.sort(singleElementArray);
        assertArrayEquals(expectedSingle, singleElementArray);
    }

    @Test
    public void testSortedArraysCase() {
        int[] expectedSortedArray = new int[]{12, 13, 14, 15, 16};
        int[] sortedArray = new int[]{12, 13, 14, 15, 16};
        sorting.sort(sortedArray);
        assertArrayEquals(expectedSortedArray, sortedArray);
    }

    @Test
    public void testOtherCases() {
        int[] expected = new int[]{2, 8, 9, 13, 15};
        int[] toSortArray = new int[]{15, 9, 13, 2, 8};
        sorting.sort(toSortArray);
        assertArrayEquals(expected, toSortArray);
    }

}