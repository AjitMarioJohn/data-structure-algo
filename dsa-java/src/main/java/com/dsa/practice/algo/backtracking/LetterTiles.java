package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 *
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 */
public class LetterTiles {

    /**
     * Give all the possible unique combinations of the given word
     * @param tile word whose combination we have to find out
     * @return @{@link List} all the possible unique combinations
     */
    public List<String> possibilities(String tile) {
        Set<String> possibilities = new HashSet<>();
        boolean[] visited = new boolean[tile.length()];
        helper(tile, visited, new StringBuilder(), possibilities);
        return new ArrayList<>(possibilities);
    }

    /**
     * recursive function that find out all the possible combination of the word
     * @param tile word whose combination we have to find out
     * @param visited keep track of visited index
     * @param current current combination we are considering
     * @param possibilities contains all the possible combinations
     */
    private void helper(String tile, boolean[] visited, StringBuilder current, Set<String> possibilities) {
        if (!current.isEmpty()) {
            possibilities.add(current.toString());
        }

        for (int index = 0; index < tile.length(); index++) {

            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            char charAtIndex = tile.charAt(index);
            current.append(charAtIndex);
            helper(tile, visited, current, possibilities);
            current.deleteCharAt(current.length() - 1);
            visited[index] = false;
        }
    }

}
