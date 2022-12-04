package com.kp.aoc.year22.day04;

import com.kp.aoc.Solver;

import java.util.List;

public class CampCleanup implements Solver<List<String>, Long> {

    private static final String DELIMITER_PAIR = ",";
    private static final String DELIMITER_RANGE = "-";

    @Override
    public Long solvePartOne(List<String> input) {
        return input.stream()
                .filter(this::overlaps)
                .count();
    }

    private boolean overlaps(String line) {
        String[] pair = line.split(DELIMITER_PAIR);
        String[] range1 = pair[0].split(DELIMITER_RANGE);
        String[] range2 = pair[1].split(DELIMITER_RANGE);

        int range1Start = Integer.parseInt(range1[0]);
        int range1End = Integer.parseInt(range1[1]);

        int range2Start = Integer.parseInt(range2[0]);
        int range2End = Integer.parseInt(range2[1]);

        return (range1Start <= range2Start && range1End >= range2End) ||
                (range2Start <= range1Start && range2End >= range1End);
    }

}
