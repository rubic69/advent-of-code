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

        Range range1 = Range.parse(pair[0]);
        Range range2 = Range.parse(pair[1]);

        return range1.encloses(range2) || range2.encloses(range1);
    }

    @Override
    public Long solvePartTwo(List<String> input) {
        return input.stream()
                .filter(this::overlaps)
                .count();
    }

    private boolean overlaps(String line) {
        String[] pair = line.split(DELIMITER_PAIR);

        Range range1 = Range.parse(pair[0]);
        Range range2 = Range.parse(pair[1]);

        return range1.overlaps(range2);
    }

    private record Range(int start, int end) {

        boolean encloses(Range range) {
            return this.start <= range.start && this.end >= range.end;
        }

        boolean overlaps(Range range) {
            return Math.max(this.start, range.start) <= Math.min(this.end, range.end);
        }

        static Range parse(String stringRepresentation) {
            String[] rangeValues = stringRepresentation.split(DELIMITER_RANGE);
            return new Range(parseInt(rangeValues[0]), parseInt(rangeValues[1]));
        }

    }
}
