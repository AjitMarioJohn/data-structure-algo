package com.dsa.practice.algo.backtracking;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().findByUsingSet(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new CombinationSumII().findByUsingSet(new int[]{2,5,2,1,2}, 5));

        System.out.println("=============================================");

        System.out.println(new CombinationSumII().find(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new CombinationSumII().find(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> find(int[] arr, int target) {
        List<List<Integer>> resultant = new ArrayList<>();
        List<Integer> runningSet = new ArrayList<>();

        // sorting is needed so that all the similar elements comes together
        Arrays.sort(arr);
        find(arr, runningSet, resultant, target, 0);

        return resultant;
    }

    private void find(int[] arr, List<Integer> runningSet, List<List<Integer>> resultant, int remainingSum, int index) {
        if (remainingSum == 0) {
            resultant.add(new ArrayList<>(runningSet));
            return;
        }

        if (remainingSum < 0 || index == arr.length) {
            return;
        }

        for (int j = index; j < arr.length; j++) {
            int num = arr[j];
            if (j > index && num == arr[j-1]) {
                continue;
            }

            runningSet.add(num);
            find(arr, runningSet, resultant, remainingSum - num, j+1);
            runningSet.remove(runningSet.size() - 1);
        }
    }

    public List<List<Integer>> findByUsingSet(int[] arr, int target) {
        Set<List<Integer>> resultant = new HashSet<>();
        List<Integer> runningSet = new ArrayList<>();

        Arrays.sort(arr);
        findByUsingSet(arr, runningSet, resultant, target, 0);

        return new ArrayList<>(resultant);
    }

    private void findByUsingSet(int[] arr, List<Integer> runningSet, Set<List<Integer>> resultant, int remainingSum, int index) {
        if (remainingSum == 0) {
            resultant.add(new ArrayList<>(runningSet));
            return;
        }

        if (remainingSum < 0 || index >= arr.length) {
            return;
        }

        int num = arr[index];
        runningSet.add(num);
        findByUsingSet(arr, runningSet, resultant, remainingSum - num, index+1);
        runningSet.remove(runningSet.size() - 1);
        findByUsingSet(arr, runningSet, resultant, remainingSum, index+1);
    }

}
