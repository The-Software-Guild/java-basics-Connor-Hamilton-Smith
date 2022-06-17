package com.wiley.c242.connorhs;

public class SummativeSums
{
    public static void main (String[] args)
    {
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array2 = { 999, -60, -77, 14, 160, 301 };
        int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };

        int sum1 = SumArray(array1);
        int sum2 = SumArray(array2);
        int sum3 = SumArray(array3);

        System.out.println("1st array sum = " + sum1);
        System.out.println("2nd array sum = " + sum2);
        System.out.println("3rd array sum = " + sum3);
    }

    /**
     * A function to sum all elements in an integer array
     * @param array: The integer array which will be summed
     * @return: Returns the sum of all elements
     */
    private static int SumArray(int[] array)
    {
        int sum = 0;

        // Loop through each element in the array
        for (int i = 0; i < array.length; i++)
        {
            // Sum up each element
            sum += array[i];
        }

        return sum;
    }

}
