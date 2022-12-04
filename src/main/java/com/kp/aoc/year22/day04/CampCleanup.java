package com.kp.aoc.year22.day04;

import com.kp.aoc.Solver;

import java.util.List;

import static java.lang.Integer.parseInt;

public class CampCleanup implements Solver<List<String>, Long> {

    private static final String DELIMITER_PAIR = ",";
    private static final String DELIMITER_RANGE = "-";

    @Override
    public Long solvePartOne(List<String> input) {
        return input.stream()
                .filter(this::encloses)
                .count();
    }

    private boolean encloses(String line) {
        String[] pair = line.split(DELIMITER_PAIR);
        String[] range1 = pair[0].split(DELIMITER_RANGE);
        String[] range2 = pair[1].split(DELIMITER_RANGE);

        int range1Start = parseInt(range1[0]);
        int range1End = parseInt(range1[1]);

        int range2Start = parseInt(range2[0]);
        int range2End = parseInt(range2[1]);

        return (range1Start <= range2Start && range1End >= range2End) ||
                (range2Start <= range1Start && range2End >= range1End);
    }

    @Override
    public Long solvePartTwo(List<String> input) {
        return input.stream()
                .filter(this::overlaps)
                .count();
    }

    private boolean overlaps(String line) {
        String[] pair = line.split(DELIMITER_PAIR);
        String[] range1 = pair[0].split(DELIMITER_RANGE);
        String[] range2 = pair[1].split(DELIMITER_RANGE);

        int range1Start = parseInt(range1[0]);
        int range1End = parseInt(range1[1]);

        int range2Start = parseInt(range2[0]);
        int range2End = parseInt(range2[1]);

        return Math.max(range1Start, range2Start) <= Math.min(range1End, range2End);
    }
}
