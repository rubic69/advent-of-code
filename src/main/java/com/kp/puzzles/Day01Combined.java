package com.kp.puzzles;

import java.util.List;

public class Day01Combined implements Puzzle<Day01Combined.Input, Integer> {

    @Override
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
