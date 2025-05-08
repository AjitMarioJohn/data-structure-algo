package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 */
public class SmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        generatePairs(0, 0, nums1, nums2, pairs);
        return pairs;
    }

    private void generatePairs(int index1, int index2, int[] nums1, int[] nums2, List<List<Integer>> pairs) {
        if (index2 == nums2.length) {
            index1++;
            index2 = 0;
        }

        if (index1 == nums1.length) {
            return;
        }

        pairs.add(List.of(nums1[index1], nums2[index2]));
        generatePairs(index1, ++index2, nums1, nums2, pairs);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestSum().kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
}
