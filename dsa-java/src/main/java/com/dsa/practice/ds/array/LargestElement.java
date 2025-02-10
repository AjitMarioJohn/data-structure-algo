package com.dsa.practice.ds.array;

/**
 * <b>Problem Statement:</b> Given an array, we have to find the largest element in the array.
 *
 * <pre>
 *     Example 1:
 *          Input:
 *              arr[] = {2,5,1,3,0};
 *          Output: 5
 * </pre>
 */
public class LargestElement {

    /**
     * Find out largest element in the given array
     * @param nums array from which largest element we have to find
     * @return {@code int} largest number in the array
     */
    public int find(final int[] nums) {
        // setting smallest value of the Integer
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
