package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Generates happy string with length n and return k<sup>th</sup> index string
     * @param n length of happy string
     * @param k index which we have to return
     * @return empty String if K<sup>th</sup> index is not present else the k<sup>th</sup> index string
     */
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        getHappyString(0, n, ' ', new StringBuilder(), happyStrings);
        System.out.println(happyStrings);
        return happyStrings.size() >= k ? happyStrings.get(k - 1) : EMPTY;
    }

    /**
     * recursive function to generate all possible happy strings
     * @param index index in which currently we are iterating
     * @param stringLength length of the happy string
     * @param lastChar last character appended to current combination
     * @param current current running combination
     * @param happyStrings contains all possible happy strings
     */
    private void getHappyString(int index, int stringLength, char lastChar, StringBuilder current, List<String> happyStrings) {
        if (index == stringLength) {
            happyStrings.add(current.toString());
            return;
        }

        for (char ch : strings) {
            if (ch == lastChar) {
                continue;
            }

            current.append(ch);
            getHappyString(index + 1, stringLength, ch, current, happyStrings);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
