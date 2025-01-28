package com.dsa.practice.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * </pre>
 * </p>
 *
 * <p>
 * <b>Example 2:</b>
 * <pre>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * </pre>
 * </p>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * <li>n == graph.length</li>
 * <li>2 <= n <= 15</li>
 * <li>0 <= graph[i][j] < n</li>
 * <li>graph[i][j] != i (i.e., there will be no self-loops).</li>
 * <li>All the elements of graph[i] are unique.</li>
 * <li>The input graph is guaranteed to be a DAG.</li>
 * </ul>
 * </p>
 */

public class SourceToTarget {

    /**
     * Finds all possible paths from the source node (0) to the target node (n - 1) in a directed acyclic graph (DAG).
     *
     * @param graph A directed acyclic graph (DAG) represented as an adjacency list, where graph[i] contains
     *              all nodes that can be visited directly from node i.
     * @return A list of all possible paths from node 0 to node n - 1, where each path is represented as
     * a list of integers.
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        allPaths(graph, 0, currentPath, allPaths);
        return allPaths;
    }

    /**
     * A helper method to find all possible paths from the current node to the target node recursively.
     *
     * @param graph       A directed acyclic graph (DAG) represented as an adjacency list, where graph[i] contains
     *                    all nodes that can be visited directly from node i.
     * @param index       The current node being explored in the graph.
     * @param currentPath The current path being constructed from the source node to the target node.
     * @param allPaths    A list of all discovered paths from the source node to the target node.
     */
    private void allPaths(int[][] graph, int index, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (index == graph.length - 1) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (Integer adjacent : graph[index]) {
            currentPath.add(adjacent);
            allPaths(graph, adjacent, currentPath, allPaths);
            currentPath.removeLast();
        }
    }

}
