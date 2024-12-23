package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    public static final int BLOCKED_BLOCK = 0;
    public static final int[][] DIRECTIONS = {{-1, 0, UP}, {1, 0, DOWN}, {0, -1, LEFT}, {0, 1, RIGHT}};

    /**
     * Finds all the possible paths
     *
     * @param mat represents maze
     * @return @{@link  List} List containing all the paths
     */
    public List<String> findPath(List<List<Integer>> mat) {
        // will contains all the possible path
        List<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[mat.size()][mat.getFirst().size()];
        helper(mat, 0, 0, new StringBuilder(), paths, visited);
        return paths;
    }

    /**
     * Recursive function that tries to find out path for rat
     *
     * @param mat         matrix which represent maze
     * @param row         row of the cell we are checking
     * @param column      column of the cell
     * @param currentPath contains current iterated path
     * @param paths       contains all the possible paths
     * @param visited
     */
    private void helper(List<List<Integer>> mat, int row, int column, StringBuilder currentPath, List<String> paths, boolean[][] visited) {
        int size = mat.size();

        // we reached the destination which is (n-1, n-1)
        if (row == size - 1 && column == mat.get(size - 1).size() - 1) {
            paths.add(currentPath.toString());
            return;
        }


        if (row < 0 || column < 0 || row >= mat.size() || column >= mat.get(row).size() || visited[row][column] || mat.get(row).get(column) == BLOCKED_BLOCK) {
            return;
        }

        // marking cell as visited
        visited[row][column] = true;

        // checking in all four directions
        for (int[] direction : DIRECTIONS) {
            currentPath.append((char) direction[2]);
            helper(mat, row + direction[0], column + direction[1], currentPath, paths, visited);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
        // unmarking cell
        visited[row][column] = false;
    }
}
