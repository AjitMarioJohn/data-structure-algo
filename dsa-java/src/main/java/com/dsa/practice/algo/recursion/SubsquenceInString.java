package com.dsa.practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsquenceInString {

    public static void main(String[] args) {
        new SubsquenceInString().find("abc");
        new SubsquenceInString().find("aa");
    }

    public void find(String str) {
        List<String> possibleSubSeq = new ArrayList<>();

        find(str, new StringBuilder(), possibleSubSeq, 0);
        System.out.println(possibleSubSeq);
    }

    private void find(String str, StringBuilder subSeqStrBuilder, List<String> possibleSubSeq, int index) {
        if (index >= str.length()) {
            String finalStr = subSeqStrBuilder.toString();
            if (!finalStr.trim().isEmpty()) {
                possibleSubSeq.add(finalStr);
            }
            return;
        }

        subSeqStrBuilder.append(str.charAt(index));
        find(str, subSeqStrBuilder, possibleSubSeq, index+1);

        subSeqStrBuilder.deleteCharAt(subSeqStrBuilder.length() - 1);
        find(str, subSeqStrBuilder, possibleSubSeq, index+1);
    }
}
