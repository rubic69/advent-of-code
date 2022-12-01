package com.kp.aoc.year21.day1;

import java.util.List;

public class Day01Part2 implements Puzzle<List<Integer>, Integer> {

    private static final int GAP = 3;

    @Override
    public Integer solve(List<Integer> input) {
        if (input.isEmpty()) {
            return 0;
        }

        int increaseCounter = 0;

        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - GAP) {
                break;
            }

            Integer current = input.get(i);
            Integer next = input.get(i + GAP);

            if (current < next) {
                increaseCounter++;
            }
        }

        return increaseCounter;
    }
}
