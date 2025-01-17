package com.dsa.practice.algo.backtracking;

/**
 * <p>
 *   Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 *   perm[i] is divisible by i.
 *   i is divisible by perm[i].
 *   Given an integer n, return the number of the beautiful arrangements that you can construct.
 * </p>
 *
 *
 *
 *<p>
 *  Example 1:
 *  Input: n = 2
 *  Output: 2
 *  Explanation:
 *  The first beautiful arrangement is [1,2]:
 *      - perm[1] = 1 is divisible by i = 1
 *      - perm[2] = 2 is divisible by i = 2
 *  The second beautiful arrangement is [2,1]:
 *      - perm[1] = 2 is divisible by i = 1
 *      - i = 2 is divisible by perm[2] = 1
 *</p>
 * <p>
 *  Example 2:
 *
 *  Input: n = 1
 *  Output: 1
 * </p>
 *
 * <p>
 *   Constraints:
 *      1 <= n <= 15
 * </p>
 */
public class BeautifulArrangement {
    int count = 0;

    /**
     * return total number of permutation that satisfy the beautiful arrangement criteria
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        int[] arr = createArray(n);
        backtracking(arr, 1);
        return count;
    }

    /**
     * recursive method to find all the permutations that statisfies beautiful arrangement criteria
     * @param arr int array whose permutation we have to find
     * @param index index of the element which we are swapping
     */
    private void backtracking(int[] arr, int index) {
        if (index == arr.length) {
            count++;
            return;
        }

        for (int secondIndex = index; secondIndex < arr.length; secondIndex++) {
            swap(arr, index, secondIndex);
            if (isBeautifulArrangement(arr, index)) {
                backtracking(arr, index+1);
            }
            swap(arr, index, secondIndex);
        }
    }

    /**
     * Swap element of the given indexes
     * @param arr int array whose element we have to swap
     * @param firstIndex first index to swap
     * @param secondIndex seconf index to swap
     */
    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] =  arr[secondIndex];
        arr[secondIndex] = temp;
    }


    /**
     * finds out whether element in the array of given position satisfies beautiful arrangement criteria
     * @param arr int array to
     * @param pos
     * @return true if satisfy the condition else false
     */
    private boolean isBeautifulArrangement(int[] arr, int pos) {
        if (arr[pos]%pos != 0 && pos%arr[pos]!=0) {
            return false;
        }
        return true;
    }

    private int[] createArray(int n) {
        int[] arr = new int[n+1];
        int index = 1;
        for (int element = 1; element <= n; element++) {
            arr[index++] = element;
        }
        return arr;
    }

}
