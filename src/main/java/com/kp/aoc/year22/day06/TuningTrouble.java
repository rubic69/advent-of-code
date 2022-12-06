package com.kp.aoc.year22.day06;

import com.kp.aoc.Solver;

import java.util.HashSet;
import java.util.Set;

public class TuningTrouble implements Solver<String, Integer> {

    @Override
    public Integer solvePartOne(String input) {
        return findIndex(input, 4);
    }

    @Override
    public Integer solvePartTwo(String input) {
        return findIndex(input, 14);
    }

    private static int findIndex(String input, int size) {
        char[] chars = input.toCharArray();

        Set<Character> set = new HashSet<>();

        for (int i = size - 1; i < chars.length; i++) {
            for (int j = 0; j < size; j++) {
                set.add(chars[i - j]);
            }

            if (set.size() == size) {
                return i + 1;
            }

            set.clear();
        }

        return -1;
    }
}
