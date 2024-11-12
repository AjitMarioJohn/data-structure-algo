package com.dsa.practice.algo.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Subset Sum : Sum of all Subsets
 * Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.
 * Examples:
 *
 * Example 1:
 *
 * Input: N = 3, arr[] = {5,2,1}
 *
 * Output: 0,1,2,3,5,6,7,8
 *
 * Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8
 *
 *
 * Input: N=3,arr[]= {3,1,2}
 *
 * Output: 0,1,2,3,3,4,5,6
 *
 * Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
 */
public class SubsetSum {

    public static void main(String[] args) {
        new SubsetSum().find(new int[]{5,2,1});
        new SubsetSum().find(new int[]{3,1,2});
    }

    public void find(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        find(arr, 0, 0, sums);
        Collections.sort(sums);
        System.out.println(sums);
    }

    private void find(int[] arr, int sum, int index, List<Integer> sums) {
        if (index >= arr.length) {
            sums.add(sum);
            return;
        }

        int num = arr[index];
        find(arr, sum+num, index+1, sums);
        find(arr, sum, index+1, sums);
    }

}
