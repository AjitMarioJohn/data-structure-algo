package com.dsa.practice.ds.array;

/**
 * <b>Find Second Smallest and Second Largest Element in an array</b>
 * <pre>
*  <b>Example 1:</b>
 *  Input: [1,2,4,7,7,5]
 *  Output:
 *     Second Smallest : 2
 * 	   Second Largest : 5
 * Explanation:
 * The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
 * </pre>
 *
 * <pre>
 * <b>Example 2:</b>
 *  Input: [1]
 *  Output:
 *      Second Smallest : -1
 * 	    Second Largest : -1
 * Explanation:
 *  Since there is only one element in the array, it is the largest and smallest element present in the array. There is no second largest or second smallest element present.
 * </pre>
 */
public class SecondLargestAndSmallestElement {
    public int[] find(int[] nums) {
        int largest = 0, secondLargest = 0;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }

        result[0] = secondSmallest;
        result[1] = secondLargest;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new SecondLargestAndSmallestElement().find(new int[]{1, 2, 4, 7, 7, 5});
        System.out.println(result[0] + " " + result[1]);

        result = new SecondLargestAndSmallestElement().find(new int[]{3, 4, 5, 2});
        System.out.println(result[0] + " " + result[1]);
    }
}
