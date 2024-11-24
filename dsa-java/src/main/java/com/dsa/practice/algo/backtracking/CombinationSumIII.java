package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 *
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 *
 */
public class CombinationSumIII {

    public static void main(String[] args) {
//        System.out.println(new CombinationSumIII().approachOne(3,7));
//        System.out.println(new CombinationSumIII().approachOne(2,18));
//        System.out.println(new CombinationSumIII().approachOne(9,45));

        System.out.println(new CombinationSumIII().approachTwo(3,7));
        System.out.println(new CombinationSumIII().approachTwo(2,18));
        System.out.println(new CombinationSumIII().approachTwo(9,45));
    }

    public List<List<Integer>> approachOne(int numOfElement, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> runningList = new ArrayList<>();
        int maxNum = Math.min(target, 9); // Not optimised due to this extra check
        approachOne(numOfElement, maxNum, runningList, result, target, 1);
        return result;
    }

    public List<List<Integer>> approachTwo(int numOfElement, int target) {
        List<List<Integer>> result = new ArrayList<>();
        approachTwo(numOfElement, new ArrayList<>(), result, target, 1);
        return result;
    }

    private void approachTwo(int numOfElement, List<Integer> runningList, List<List<Integer>> resultant, int remainingSum, int num) {
        if (remainingSum == 0 && runningList.size() == numOfElement) {
            resultant.add(new ArrayList<>(runningList));
            return;
        }

        if (remainingSum < 0 || runningList.size() > numOfElement) {
            return;
        }

        for (int start = num; start <= 9; start++) {
            runningList.add(start);
            approachTwo(numOfElement, runningList, resultant, remainingSum - start, start+1);
            runningList.remove(runningList.size() - 1);
        }
    }

    private void approachOne(int numOfElement, int maxNum, List<Integer> runningList, List<List<Integer>> resultant, int remainingSum, int num) {
        if (remainingSum == 0 && runningList.size() == numOfElement) {
            resultant.add(new ArrayList<>(runningList));
            return;
        }

        if (remainingSum < 0 || runningList.size() > numOfElement || num > maxNum) {
            return;
        }

        runningList.add(num);
        approachOne(numOfElement, maxNum, runningList, resultant, remainingSum - num, num+1);
        runningList.remove(runningList.size() - 1);
        approachOne(numOfElement, maxNum, runningList, resultant, remainingSum, num+1);
    }
}
