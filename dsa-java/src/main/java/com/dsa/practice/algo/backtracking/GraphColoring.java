package com.dsa.practice.algo.backtracking;

import java.util.*;

public class GraphColoring {
    private final List<Set<Integer>> adjacentList;
    private final int vertices;

    public static void main(String[] args) {
        GraphColoring graph = new GraphColoring(4);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);

        graph.findColorCombinations(3);
    }

    public GraphColoring(int vertices) {
        this.vertices = vertices;
        adjacentList = new ArrayList<>(vertices);

        for (int index = 0; index < vertices; index++) {
            adjacentList.add(new HashSet<>());
        }
    }

    public void addEdge(int v, int w) {
        adjacentList.get(v).add(w);
        adjacentList.get(w).add(v);
    }

    public void findColorCombinations(int numOfColors) {
        int[] colors = new int[vertices];
        List<int[]> possibilities = new ArrayList<>();
        Arrays.fill(colors, 0);
        findColorCombinations(colors, 0, numOfColors, possibilities);

        for (int[] combination : possibilities) {
            System.out.println(Arrays.toString(combination));
        }
    }

    private void findColorCombinations(int[] colors, int index, int numOfColors, List<int[]> possibilities) {
        if (index == vertices) {
            possibilities.add(colors.clone());
            return;
        }

        for (int color = 1; color <= numOfColors; color++) {
            if (!canApply(colors, color, index)) {
                continue;
            }

            colors[index] = color;
            findColorCombinations(colors, index+1, numOfColors, possibilities);
            colors[index] = 0;
        }
    }

    private boolean canApply(int[] colors, int color, int index) {
        for (int adjacent : adjacentList.get(index)) {
            if (colors[adjacent] == color) {
                return false;
            }
        }
        return true;
    }
}
