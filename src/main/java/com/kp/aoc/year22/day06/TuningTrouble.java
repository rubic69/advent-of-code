package com.kp.aoc.year22.day06;

import com.kp.aoc.Solver;

import java.util.HashSet;
import java.util.Set;

public class TuningTrouble implements Solver<String, Integer> {

    @Override
    public Integer solvePartOne(String input) {
        char[] chars = input.toCharArray();

        Set<Character> set = new HashSet<>();

        for (int i = 3; i < chars.length; i++) {
            set.add(chars[i - 3]);
            set.add(chars[i - 2]);
            set.add(chars[i - 1]);
            set.add(chars[i]);

            if (set.size() == 4) {
                return i + 1;
            }

            set.clear();
        }

        return -1;
    }

}
