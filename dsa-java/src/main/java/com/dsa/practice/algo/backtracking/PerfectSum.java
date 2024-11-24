package com.dsa.practice.algo.backtracking;

import java.util.Arrays;

/**
 * Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
 *
 * Note: Answer can be very large, so, output answer modulo 109+7.
 *
 * Examples:
 *
 * Input:
 * n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
 * Output:
 * 3
 * Explanation:
 * {5, 2, 3}, {2, 8}, {10} are possible subsets.
 * Input:
 * n = 5, arr = [2, 5, 1, 4, 3], sum = 10
 * Output:
 * 3
 * Explanation:
 * {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
 *
 * Expected Time Complexity: O(n*sum)
 * Expected Auxiliary Space: O(n*sum)
 *
 * Constraints:
 * 1 ≤ n*sum ≤ 106
 * 0 ≤ arr[i] ≤ 10
 */
public class PerfectSum {

    public static void main(String[] args) {
        new PerfectSum().count(new int[]{5, 2, 3, 10, 6, 8}, 10);
        new PerfectSum().count(new int[]{2, 5, 1, 4, 3}, 10);
        new PerfectSum().count(new int[]{1,0}, 1);
    }

    public void count(int[] arr, int sum) {
        Arrays.sort(arr);
        int count = count(arr, sum, 0, 0);
        System.out.println(count);
    }

    private int count(int[] arr, int sum, int resultantSum, int index) {
        if (sum == resultantSum) {
            return 1;
        }

        if (index >= arr.length) {
            return 0;
        }

        int consider = count(arr, sum, resultantSum + arr[index], index+1);
        int notConsider = count(arr, sum, resultantSum, index+1);
        return consider + notConsider;
    }


}
