package com.kp.aoc.year22.day01;

import com.kp.aoc.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day01 implements Solver<Day01.Input, Integer> {

    @Override
    public Integer solvePartOne(Day01.Input input) {
        return performGenericSolve(input);
    }

    @Override
    public Integer solvePartTwo(Day01.Input input) {
        return performGenericSolve(input);
    }

    private static Integer performGenericSolve(Input input) {
        ArrayList<Integer> topHighestAmounts = new ArrayList<>();
        AtomicInteger currentAmount = new AtomicInteger(0);

        input.calories().forEach(amount -> {
            if (amount != null) {
                currentAmount.addAndGet(amount);
            } else {
                updateTopHighestAmounts(input.topRecordsAmount(), topHighestAmounts, currentAmount);
                currentAmount.set(0);
            }
        });

        updateTopHighestAmounts(input.topRecordsAmount(), topHighestAmounts, currentAmount);

        return topHighestAmounts.stream().reduce(0, Integer::sum);
    }

    private static void updateTopHighestAmounts(int size, ArrayList<Integer> topHighestAmounts, AtomicInteger currentAmount) {
        topHighestAmounts.add(currentAmount.get());
        topHighestAmounts.sort(Integer::compareTo);
        if (topHighestAmounts.size() > size) {
            topHighestAmounts.remove(0);
        }
    }

    protected record Input(
            int topRecordsAmount,
            List<Integer> calories
    ) {
    }
}
