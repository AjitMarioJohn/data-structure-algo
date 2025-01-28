package com.dsa.practice.algo.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for SourceToTarget class.
 * <p>
 * The SourceToTarget class provides a method `allPathsSourceTarget`
 * that computes all possible paths from the source node (node 0) to the target node
 * in a given directed acyclic graph represented as an adjacency list.
 */
public class SourceToTargetTest {

    /**
     * Test case where the graph contains multiple valid paths.
     * Ensures that all paths from source to target are correctly identified.
     */
    @Test
    public void testMultiplePaths() {
        int[][] graph = {
                {1, 2, 3},
                {3},
                {3},
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1, 3));
        expected.add(Arrays.asList(0, 2, 3));
        expected.add(Arrays.asList(0, 3));
        assertEquals(expected, actual);
    }

    /**
     * Test case where the graph initially has no outgoing edges from the source.
     * Ensures that an empty result is returned.
     */
    @Test
    public void testNoPaths() {
        int[][] graph = {
                {},
                {2, 3},
                {3},
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    /**
     * Test case with a single-node graph.
     * Ensures that the source and the target being the same node is handled correctly.
     */
    @Test
    public void testSingleNodeGraph() {
        int[][] graph = {
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0));
        assertEquals(expected, actual);
    }

    /**
     * Test case where there is a single direct path from source to target.
     * Ensures the correct result is produced for straightforward graphs.
     */
    @Test
    public void testSinglePath() {
        int[][] graph = {
                {1},
                {2},
                {3},
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1, 2, 3));
        assertEquals(expected, actual);
    }

    /**
     * Test case where the source node has multiple branches leading to the target node.
     * Ensures all branching paths are correctly identified.
     */
    @Test
    public void testBranchingPaths() {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 1, 3));
        expected.add(Arrays.asList(0, 2, 3));
        assertEquals(expected, actual);
    }

    @Test
    public void testBranchingPathsWithMoreThanOneEmptyNode() {
        int[][] graph = {
                {4,3,1},
                {3,2,4},
                {},
                {4},
                {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = List.of(List.of(0,4), List.of(0,3,4), List.of(0,1,3,4), List.of(0,1,4));
        assertEquals(expected, actual);
    }

    /**
     * Test case where the graph contains no edges (all nodes have no outgoing connections).
     * Ensures an empty result is returned in this scenario.
     */
    @Test
    public void testNoEdges() {
        int[][] graph = {
                {}, {}, {}, {}
        };
        SourceToTarget sourceToTarget = new SourceToTarget();
        List<List<Integer>> actual = sourceToTarget.allPathsSourceTarget(graph);
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }
}