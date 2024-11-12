package com.dsa.practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset - II | Print all the Unique Subsets

 * Problem Statement: Given an array of integers that may contain duplicates the task is to return all possible subsets. Return only unique subsets and they can be in any order.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: array[] = [1,2,2]
 *
 * Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
 *
 * Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.
 *
 * Input: array[] = [1]
 *
 * Output: [ [ ], [1] ]
 *
 * Explanation: Only two unique subsets are available
 */
public class UniqueSubset {

    public static void main(String[] args) {
        new UniqueSubset().find(new int[]{1,2,2});
    }

    public void find(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        find(arr, 0, new ArrayList<Integer>(), subsets);
        System.out.println(subsets);
    }

    private void find(int[] arr, int index, List<Integer> subset, List<List<Integer>> subsetList) {
        subsetList.add(new ArrayList<>(subset));

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i-1]) {
                continue;
            }

            subset.add(arr[i]);
            find(arr, i+1, subset, subsetList);
            subset.remove(subset.size() - 1);
        }
    }
}
