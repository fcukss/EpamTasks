package com.epam.rd.SortingAppVerAppTwo;

import static org.junit.Assert.*;

import com.epam.rd.SortingAppVerTwo.Main;
import org.junit.Test;

public class MainTest {

    @Test
    public void TestShouldCorrectSort() {
        Main m = new Main();
        int[] res = m.sort(new int[]{9, 8, 5, 4, 3});
        assertArrayEquals(new int[]{3, 4, 5, 8, 9}, res);
    }
    @Test
    public void TestEmpryArray() {
        Main m = new Main();
        int[] res = m.sort(new int[]{});
        assertArrayEquals(new int[]{}, res);
    }
    @Test (expected = NullPointerException.class)
    public void TestNullException() {
        Main m = new Main();
        int[] res = m.sort(null);
        assertArrayEquals(null, res);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void TestOutOfBoundsException() {
        Main m = new Main();
        int[] res = m.sort(new int[]{1,2,3,5,6,7,8,9,0,10,11});
    }


}
