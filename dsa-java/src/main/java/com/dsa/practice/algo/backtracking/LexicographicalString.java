package com.dsa.practice.algo.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy string is a string that:
 *
 * consists only of letters of the set ['a', 'b', 'c'].
 * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.
 *
 * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
 *
 * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 * Example 2:
 *
 * Input: n = 1, k = 4
 * Output: ""
 * Explanation: There are only 3 happy strings of length 1.
 * Example 3:
 *
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10
 * 1 <= k <= 100
 */
public class LexicographicalString {

    private final char[] strings = {'a', 'b', 'c'};
    private final String EMPTY = "";

    public String getHappyString(int n, int k) {
        boolean[] used = new boolean[strings.length];
        Set<String> happyStrings = new HashSet<>();
        generateHappyStrings(strings, used, n, new StringBuilder(), happyStrings);

        if (happyStrings.size() < k) {
            return EMPTY;
        }

        return happyStrings.toArray(new String[]{})[k - 1];
    }

    private void generateHappyStrings(char[] strings, boolean[] used, int wordLength, StringBuilder current, Set<String> happyStrings) {
        if (current.length() == wordLength) {
            happyStrings.add(current.toString());
            return;
        }

        for (int index = 0; index < strings.length; index++) {
            if (used[index]) {
                continue;
            }

            used[index] = true;
            current.append(strings[index]);
            generateHappyStrings(strings, used, wordLength, current, happyStrings);
            current.deleteCharAt(current.length() - 1);
            used[index] = false;
        }
    }


}
