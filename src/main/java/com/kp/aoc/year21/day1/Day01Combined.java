package com.kp.aoc.year21.day1;

import com.kp.aoc.Solver;

import java.util.List;

public class Day01Combined implements Solver<Day01Combined.Input, Integer> {

    @Override
    public Integer solvePartOne(Input input) {
        return solve(input);
    }

    @Override
    public Integer solvePartTwo(Input input) {
        return solve(input);
    }

    public Integer solve(Input input) {
        List<Integer> depths = input.depths();
        if (depths.isEmpty()) {
            return 0;
        }

        int increaseCounter = 0;

        final int gap = input.gap();
        int listCeiling = depths.size() - gap;

        for (int i = 0; i < listCeiling; i++) {
            Integer current = depths.get(i);
            Integer next = depths.get(i + gap);

            if (current < next) {
                increaseCounter++;
            }
        }

        return increaseCounter;
    }

    protected record Input(int gap, List<Integer> depths) {

    }
}
