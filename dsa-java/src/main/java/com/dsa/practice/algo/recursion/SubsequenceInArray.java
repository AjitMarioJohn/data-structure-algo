package com.dsa.practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceInArray {
    public static void main(String[] args) {
        new SubsequenceInArray().find(new int[]{3,2,1});
    }

    public void find(int[] arr) {
        List<Integer> subSeq = new ArrayList<>();
        List<List<Integer>> possibleSubSeq = new ArrayList<>();
        find(arr, subSeq, possibleSubSeq, 0);
        System.out.println(possibleSubSeq);
    }

    private void find(int[] arr, List<Integer> subSeq, List<List<Integer>> possibleSubSeq, int index) {
        if (index >= arr.length) {
            possibleSubSeq.add(new ArrayList<>(subSeq));
            return;
        }

        //Take
        subSeq.add(arr[index]);
        find(arr, subSeq, possibleSubSeq, index+1);

        //Not take
        subSeq.remove(subSeq.size() - 1);
        find(arr, subSeq, possibleSubSeq, index+1);
    }
}
