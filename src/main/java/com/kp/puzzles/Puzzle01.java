package com.kp.puzzles;

import java.util.Iterator;
import java.util.List;

public class Puzzle01 implements Puzzle<List<Integer>, Integer> {

    @Override
    public Integer solve(List<Integer> input) {
        if (input.isEmpty()) {
            return 0;
        }

        int increaseCounter = 0;

        Iterator<Integer> iterator = input.iterator();
        Integer current = iterator.next();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (current < next) {
                increaseCounter++;
            }

            current = next;
        }

        return increaseCounter;
    }
}
