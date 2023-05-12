import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * This class tests ArrayListSorter's implementations
 * of mergesort and quicksort.
 *
 * @author Mairin Kelly and Keegan Richardson
 * @version 2/17/23
 */

public class ArrayListSorterTest2 {
    public static void main(String[] args) {
    }
    @Test
    /**
     * This tests merge sort on a short
     * list of integers.
     */
    public void mergesortInt()
    {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(5);
        arrList.add(12);
        arrList.add(10);
        arrList.add(2);
        ArrayListSorter2.sort(arrList,1);
        Integer expected0 = 2;
        Integer expected1 = 5;
        Integer expected2 = 10;
        Integer expected3 = 12;

        assertEquals(expected0, arrList.get(0));
        assertEquals(expected1, arrList.get(1));
        assertEquals(expected2, arrList.get(2));
        assertEquals(expected3, arrList.get(3));
    }

    @Test
    /**
     * This tests merge sort on a medium
     * list of integers.
     */
    public void mergesortInt2()
    {
        ArrayList<Integer> arr = ArrayListSorter2.generatePermuted(151);
        ArrayListSorter2.sort(arr,2);
        for (int i = 1; i <= arr.size(); i++)
        {
            assertEquals((Integer) i, arr.get(i-1));
        }
    }

    @Test
    /**
     * This tests merge sort on a large
     * list of integers.
     */
    public void mergesortInt3()
    {
        ArrayList<Integer> arr = ArrayListSorter2.generateAscending(1121);
        ArrayListSorter2.sort(arr,2);
        for (int i = 1; i <= arr.size(); i++)
        {
            assertEquals((Integer) i, arr.get(i-1));
        }
    }

    @Test
    /**
     * This tests merge sort on a small
     * list of strings.
     */
    public void mergesortString()
    {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("fringe");
        arr.add("cartwheel");
        arr.add("computer");
        ArrayListSorter2.sort(arr,2);
        assertEquals("cartwheel",arr.get(0));
        assertEquals("computer",arr.get(1));
        assertEquals("fringe",arr.get(2));
    }

    @Test
    /**
     * This tests merge sort on a medium
     * list of strings.
     */
    public void mergesortString2()
    {
        ArrayList<String> arr = new ArrayList<String>(56);
        for (int i = 65; i < 79; i++)
        {
            String s = String.valueOf(i);
            arr.add(s);
        }
        Collections.shuffle(arr);
        ArrayListSorter2.sort(arr,2);
        for (int i = 0; i < arr.size(); i++)
        {
            assertEquals(String.valueOf(i+65), arr.get(i));
        }
    }

    @Test
    /**
     * This tests quick sort on a short
     * list of integers.
     */
    public void quicksortInt()
    {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(20);
        arrList.add(6);
        arrList.add(12);
        arrList.add(32);
        arrList.add(5);
        arrList.add(18);
        arrList.add(1);
        ArrayListSorter2.sort(arrList,"random");

        Integer expected0 = 1;
        Integer expected1 = 5;
        Integer expected2 = 6;
        Integer expected3 = 12;

        assertEquals(expected0, arrList.get(0));
        assertEquals(expected1, arrList.get(1));
        assertEquals(expected2, arrList.get(2));
        assertEquals(expected3, arrList.get(3));
    }

    @Test
    /**
     * This tests quick sort on a medium
     * list of integers.
     */
    public void quicksortInt2()
    {
        ArrayList<Integer> arr = ArrayListSorter2.generateAscending(150);
        ArrayListSorter2.sort(arr,"first");
        System.out.println(arr);
        for (int i = 1; i <= arr.size(); i++)
        {
            assertEquals((Integer) i, arr.get(i-1));
        }

    }

    @Test
    /**
     * This tests the generateAscending
     * method.
     */
    public void generateAscending()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ArrayList<Integer> arr2 =  ArrayListSorter2.generateAscending(3);
        assertEquals(arr,arr2);
    }

    @Test
    /**
     * This tests the generateDescending
     * method.
     */
    public void generateDescending()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(2);
        arr.add(1);
        ArrayList<Integer> arr2 =  ArrayListSorter2.generateDescending(3);
        assertEquals(arr,arr2);
    }

    @Test
    /**
     * This tests the generatePermuted
     * method.
     */
    public void generatePermuted()
    {
        ArrayList<Integer> arr2 =  ArrayListSorter2.generatePermuted(7);
        for (int i = 1; i <= arr2.size(); i++)
        {
            // make sure array contains all expected values
            boolean contains = arr2.contains(i);
            assertEquals(true,contains);
        }
    }
}